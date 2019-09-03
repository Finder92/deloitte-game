package io.renren.modules.attend.config;

import com.alibaba.fastjson.JSONObject;
import io.renren.modules.attend.dto.attr.AttrDTO;
import io.renren.modules.attend.dto.message.ShowDto;
import io.renren.modules.attend.dto.subject.SubjectDTO;
import io.renren.modules.attend.dto.unrecognized.UnrecognizedDto;
import io.renren.modules.attend.dto.video.VideoDTO;
import io.renren.modules.attend.service.HttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName WebSocketConfig
 * @Description TODO
 * @Author Finder
 * @Date 2019/7/30 16:22
 */

@Slf4j
@Component
public class WebSocketConfig {
    @Autowired
    private AttendConfig attendConfig;

    @Autowired
    private HttpClientService httpClientService;

    @Autowired
    private RequestConfig requestConfig;

    ShowDto showDto = new ShowDto();

    @Bean
    public WebSocketClient webSocketClient() {
        try {
            //主机地址
            String wsUrl = attendConfig.getWsUrl();
            //视频流地址
            String rtspUrl = attendConfig.getRtspUrl();
            //websocket连接
            String ws = wsUrl + "?url=" + URLEncoder.encode(rtspUrl, "utf-8");
            WebSocketClient webSocketClient = new WebSocketClient(new URI(ws), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    log.info("[websocket] 连接成功");
                    //当连接成功  去进行登陆
                    loginMegvii();
                    log.info("登录[megvii]成功");
                }

                @Override
                public void onMessage(String message) {
                    log.info("");
                    VideoDTO videoDTO = JSONObject.parseObject(message, VideoDTO.class);
                    if (videoDTO.getType().equals("recognized") || videoDTO.getType().equals("unrecognized") || videoDTO.getType().equals("attr")) {
                        //recognized  为底库中存在的,unrecognized在底库中不存在的
                        if (videoDTO.getType().equals("recognized")) {
                            log.info("type1=:" + videoDTO.getType());
                            String resultSubject = httpClientService.doGet("http://192.168.1.50/subject/" + videoDTO.getPerson().getId());
                            SubjectDTO subjectDTO = JSONObject.parseObject(resultSubject, SubjectDTO.class);
                            showDto.setPictureUrl("http://192.168.1.50" + subjectDTO.getData().getPhotos().get(0).getUrl());
                            showDto.setType("1");
                        } else if (videoDTO.getType().equals("unrecognized")) {
                            //设为员工
                            log.info("type3=:" + videoDTO.getType());
                            log.info("unrecognized-message:" + message);
                            UnrecognizedDto unrecognizedDto = JSONObject.parseObject(message, UnrecognizedDto.class);
                            String base64Img = unrecognizedDto.getData().getFace().getImage();
                            showDto.setType("0");
                            showDto.setPictureUrl("data:image/jpeg;base64," + base64Img);

                        } else if (videoDTO.getType().equals("attr")) {
                            log.info("attr-message:" + message);
                            log.info("type2=:" + videoDTO.getType());
                            AttrDTO attrDTO = JSONObject.parseObject(message, AttrDTO.class);
                            String age = String.valueOf((int) Math.ceil(attrDTO.getData().getAttr().getAge()));
                            log.info("age:{}", age);
                            int intAge = Integer.valueOf(age);
                            if (intAge < 18) {
                                intAge = (int) (18 + Math.random() * 7);
                            } else if (intAge > 40) {
                                intAge = (int) (35 + Math.random() * 6);
                            }
                            age = String.valueOf(intAge);
                            showDto.setAge(age);
                        }
                        if (showDto.getType() == null || showDto.getAge() == null) {
                            log.info("获取信息不完整");
                            return;
                        } else if (showDto.getType() != null && showDto.getAge() != null) {
                            System.out.println("发送至 controller" + System.currentTimeMillis());
                            Map<String, String> messageParamsMap = new HashMap<>();
                            //领导
                            messageParamsMap.put("type", showDto.getType());
                            messageParamsMap.put("pictureUrl", showDto.getPictureUrl());
                            messageParamsMap.put("age", showDto.getAge());
                            httpClientService.doPost("http://192.168.1.100:8089/message", messageParamsMap);
                            showDto = new ShowDto();
                        }

                    } else {
                        log.info(videoDTO.getType());
                        log.info("心跳检测报文或者识别过程中的报文*message:{}", message);
                    }

                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    log.info("[websocket] 退出连接"+code+reason+remote);
                }

                @Override
                public void onError(Exception ex) {
                    log.info("[websocket] 连接错误={}", ex.getMessage());
                }
            };
            webSocketClient.connect();
            return webSocketClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return
     * @Author Finder
     * @Description //TODO 为了获取cookie
     * @Date 16:09 2019/7/29
     * @Param
     */
    public String loginMegvii() {
        Map<String, String> params = new ConcurrentHashMap<>();
        params.put("username", requestConfig.getUsername());
        params.put("password", requestConfig.getPassword());
        String result = httpClientService.doPost(requestConfig.getLoginUrl(), params);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
        result = jsonObject.get("code").toString();
        log.info("result:{登录返回状态码:=}" + result);
        log.info("result:{}", result);
        return result;
    }


}
