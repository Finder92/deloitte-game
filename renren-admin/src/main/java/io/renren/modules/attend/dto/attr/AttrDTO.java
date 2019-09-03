package io.renren.modules.attend.dto.attr;

import java.util.List;

/**
 * @ClassName AttrDTO
 * @Description TODO
 * @Author Finder
 * @Date 2019/8/11 18:20
 **/
public class AttrDTO {

    /**
     * data : {"attr":{"minority":1.6764058727858355E-6,"left_eye":[0.05728296935558319,3.820814981736476E-6,0.9423996210098267,1.8274049216415733E-4,1.2342349509708583E-4,7.4363001658639405E-6],"gender":[0.015711773186922073,0.984288215637207],"age":26.886302947998047,"pose":{"yaw":-1.1132328960265145,"roll":-8.173189629718495,"pitch":-0.9801859336365435},"fmp":{"fabricate":0,"panorama":0,"mask":0,"prediction":0},"right_eye":[0.06819552928209305,4.374550189822912E-5,0.9239504337310791,0.0040318467654287815,0.003712758421897888,6.576804298674688E-5],"kgb":0,"mouth":[5.3482157938433694E-12,1.461486626164188E-10,0.9999808073043823,1.924588104884606E-5],"monochromic":0.44335906201591796,"quality":{"illumination":0,"blurness":0.0017571041826158762,"pose":0,"expression":0,"occlusion":0}},"track":72,"timestamp":1565517711920034416,"image":"/9j/4AAQSkZJRgABAQAA","frame_id":385007,"quality_compoments":{"blurness":0.0017571041826158762,"yaw":-1.1132328960265145,"roll":-8.173189629718495,"pitch":-0.9801859336365435},"snapshot_status":"gone","face_confidence":0.9999834299087524,"quality":0.9982428958173841,"rect":{"top":118,"right":1198,"bottom":506,"left":812}}
     * type : attr
     */

    private DataBean data;
    private String type;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class DataBean {
        /**
         * attr : {"minority":1.6764058727858355E-6,"left_eye":[0.05728296935558319,3.820814981736476E-6,0.9423996210098267,1.8274049216415733E-4,1.2342349509708583E-4,7.4363001658639405E-6],"gender":[0.015711773186922073,0.984288215637207],"age":26.886302947998047,"pose":{"yaw":-1.1132328960265145,"roll":-8.173189629718495,"pitch":-0.9801859336365435},"fmp":{"fabricate":0,"panorama":0,"mask":0,"prediction":0},"right_eye":[0.06819552928209305,4.374550189822912E-5,0.9239504337310791,0.0040318467654287815,0.003712758421897888,6.576804298674688E-5],"kgb":0,"mouth":[5.3482157938433694E-12,1.461486626164188E-10,0.9999808073043823,1.924588104884606E-5],"monochromic":0.44335906201591796,"quality":{"illumination":0,"blurness":0.0017571041826158762,"pose":0,"expression":0,"occlusion":0}}
         * track : 72
         * timestamp : 1565517711920034416
         * image : /9j/4AAQSkZJRgABAQAA
         * frame_id : 385007
         * quality_compoments : {"blurness":0.0017571041826158762,"yaw":-1.1132328960265145,"roll":-8.173189629718495,"pitch":-0.9801859336365435}
         * snapshot_status : gone
         * face_confidence : 0.9999834299087524
         * quality : 0.9982428958173841
         * rect : {"top":118,"right":1198,"bottom":506,"left":812}
         */

        private AttrBean attr;
        private int track;
        private long timestamp;
        private String image;
        private int frame_id;
        private QualityCompomentsBean quality_compoments;
        private String snapshot_status;
        private double face_confidence;
        private double quality;
        private RectBean rect;

        public AttrBean getAttr() {
            return attr;
        }

        public void setAttr(AttrBean attr) {
            this.attr = attr;
        }

        public int getTrack() {
            return track;
        }

        public void setTrack(int track) {
            this.track = track;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getFrame_id() {
            return frame_id;
        }

        public void setFrame_id(int frame_id) {
            this.frame_id = frame_id;
        }

        public QualityCompomentsBean getQuality_compoments() {
            return quality_compoments;
        }

        public void setQuality_compoments(QualityCompomentsBean quality_compoments) {
            this.quality_compoments = quality_compoments;
        }

        public String getSnapshot_status() {
            return snapshot_status;
        }

        public void setSnapshot_status(String snapshot_status) {
            this.snapshot_status = snapshot_status;
        }

        public double getFace_confidence() {
            return face_confidence;
        }

        public void setFace_confidence(double face_confidence) {
            this.face_confidence = face_confidence;
        }

        public double getQuality() {
            return quality;
        }

        public void setQuality(double quality) {
            this.quality = quality;
        }

        public RectBean getRect() {
            return rect;
        }

        public void setRect(RectBean rect) {
            this.rect = rect;
        }

        public static class AttrBean {
            /**
             * minority : 1.6764058727858355E-6
             * left_eye : [0.05728296935558319,3.820814981736476E-6,0.9423996210098267,1.8274049216415733E-4,1.2342349509708583E-4,7.4363001658639405E-6]
             * gender : [0.015711773186922073,0.984288215637207]
             * age : 26.886302947998047
             * pose : {"yaw":-1.1132328960265145,"roll":-8.173189629718495,"pitch":-0.9801859336365435}
             * fmp : {"fabricate":0,"panorama":0,"mask":0,"prediction":0}
             * right_eye : [0.06819552928209305,4.374550189822912E-5,0.9239504337310791,0.0040318467654287815,0.003712758421897888,6.576804298674688E-5]
             * kgb : 0
             * mouth : [5.3482157938433694E-12,1.461486626164188E-10,0.9999808073043823,1.924588104884606E-5]
             * monochromic : 0.44335906201591796
             * quality : {"illumination":0,"blurness":0.0017571041826158762,"pose":0,"expression":0,"occlusion":0}
             */

            private double minority;
            private double age;
            private PoseBean pose;
            private FmpBean fmp;
            private int kgb;
            private double monochromic;
            private QualityBean quality;
            private List<Double> left_eye;
            private List<Double> gender;
            private List<Double> right_eye;
            private List<Double> mouth;

            public double getMinority() {
                return minority;
            }

            public void setMinority(double minority) {
                this.minority = minority;
            }

            public double getAge() {
                return age;
            }

            public void setAge(double age) {
                this.age = age;
            }

            public PoseBean getPose() {
                return pose;
            }

            public void setPose(PoseBean pose) {
                this.pose = pose;
            }

            public FmpBean getFmp() {
                return fmp;
            }

            public void setFmp(FmpBean fmp) {
                this.fmp = fmp;
            }

            public int getKgb() {
                return kgb;
            }

            public void setKgb(int kgb) {
                this.kgb = kgb;
            }

            public double getMonochromic() {
                return monochromic;
            }

            public void setMonochromic(double monochromic) {
                this.monochromic = monochromic;
            }

            public QualityBean getQuality() {
                return quality;
            }

            public void setQuality(QualityBean quality) {
                this.quality = quality;
            }

            public List<Double> getLeft_eye() {
                return left_eye;
            }

            public void setLeft_eye(List<Double> left_eye) {
                this.left_eye = left_eye;
            }

            public List<Double> getGender() {
                return gender;
            }

            public void setGender(List<Double> gender) {
                this.gender = gender;
            }

            public List<Double> getRight_eye() {
                return right_eye;
            }

            public void setRight_eye(List<Double> right_eye) {
                this.right_eye = right_eye;
            }

            public List<Double> getMouth() {
                return mouth;
            }

            public void setMouth(List<Double> mouth) {
                this.mouth = mouth;
            }

            public static class PoseBean {
                /**
                 * yaw : -1.1132328960265145
                 * roll : -8.173189629718495
                 * pitch : -0.9801859336365435
                 */

                private double yaw;
                private double roll;
                private double pitch;

                public double getYaw() {
                    return yaw;
                }

                public void setYaw(double yaw) {
                    this.yaw = yaw;
                }

                public double getRoll() {
                    return roll;
                }

                public void setRoll(double roll) {
                    this.roll = roll;
                }

                public double getPitch() {
                    return pitch;
                }

                public void setPitch(double pitch) {
                    this.pitch = pitch;
                }
            }

            public static class FmpBean {
                /**
                 * fabricate : 0
                 * panorama : 0
                 * mask : 0
                 * prediction : 0
                 */

                private int fabricate;
                private int panorama;
                private int mask;
                private int prediction;

                public int getFabricate() {
                    return fabricate;
                }

                public void setFabricate(int fabricate) {
                    this.fabricate = fabricate;
                }

                public int getPanorama() {
                    return panorama;
                }

                public void setPanorama(int panorama) {
                    this.panorama = panorama;
                }

                public int getMask() {
                    return mask;
                }

                public void setMask(int mask) {
                    this.mask = mask;
                }

                public int getPrediction() {
                    return prediction;
                }

                public void setPrediction(int prediction) {
                    this.prediction = prediction;
                }
            }

            public static class QualityBean {
                /**
                 * illumination : 0
                 * blurness : 0.0017571041826158762
                 * pose : 0
                 * expression : 0
                 * occlusion : 0
                 */

                private int illumination;
                private double blurness;
                private int pose;
                private int expression;
                private int occlusion;

                public int getIllumination() {
                    return illumination;
                }

                public void setIllumination(int illumination) {
                    this.illumination = illumination;
                }

                public double getBlurness() {
                    return blurness;
                }

                public void setBlurness(double blurness) {
                    this.blurness = blurness;
                }

                public int getPose() {
                    return pose;
                }

                public void setPose(int pose) {
                    this.pose = pose;
                }

                public int getExpression() {
                    return expression;
                }

                public void setExpression(int expression) {
                    this.expression = expression;
                }

                public int getOcclusion() {
                    return occlusion;
                }

                public void setOcclusion(int occlusion) {
                    this.occlusion = occlusion;
                }
            }
        }

        public static class QualityCompomentsBean {
            /**
             * blurness : 0.0017571041826158762
             * yaw : -1.1132328960265145
             * roll : -8.173189629718495
             * pitch : -0.9801859336365435
             */

            private double blurness;
            private double yaw;
            private double roll;
            private double pitch;

            public double getBlurness() {
                return blurness;
            }

            public void setBlurness(double blurness) {
                this.blurness = blurness;
            }

            public double getYaw() {
                return yaw;
            }

            public void setYaw(double yaw) {
                this.yaw = yaw;
            }

            public double getRoll() {
                return roll;
            }

            public void setRoll(double roll) {
                this.roll = roll;
            }

            public double getPitch() {
                return pitch;
            }

            public void setPitch(double pitch) {
                this.pitch = pitch;
            }
        }

        public static class RectBean {
            /**
             * top : 118
             * right : 1198
             * bottom : 506
             * left : 812
             */

            private int top;
            private int right;
            private int bottom;
            private int left;

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getRight() {
                return right;
            }

            public void setRight(int right) {
                this.right = right;
            }

            public int getBottom() {
                return bottom;
            }

            public void setBottom(int bottom) {
                this.bottom = bottom;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }
        }
    }
}
