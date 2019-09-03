package io.renren.modules.attend.controller;

import com.alibaba.fastjson.JSON;
import io.renren.modules.attend.dto.message.ShowDto;
import io.renren.modules.attend.websocket.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MessageController
 * @Description TODO
 * @Author Finder
 * @Date 2019/8/7 8:38
 **/
@RestController
@Slf4j
public class MessageController {
    @Resource
    WebSocketServer webSocketServer;

    @RequestMapping("/message")
    public String reciveMessage(ShowDto showDto) {
        log.info("age:" + showDto.getAge());
        log.info("type:" + showDto.getType());
        log.info("pictureUrl:" + showDto.getPictureUrl());
        final String message = JSON.toJSONString(showDto);
        try {
            webSocketServer.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
