package com.ch.nd.utility;

public interface Constant {
    interface BroadcastAction {
        String CHIEN_ND = "chien_nd";
    }

    interface IntentKey {
        String OBJECT = "object";
        String OBJECTS = "objects";
        String TYPE = "type";
    }

    enum TypeUser {
        FREE("1"), PAIDED("2"), VIP("3"), VIP_PRO("4");
        private String type;

        TypeUser(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    enum TypeLogger {
        LIFECYCLE("lifecycle");
        private String type;

        TypeLogger(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    enum Directory {

        EXTERNAL_STORAGE_FOLDER_APP("ch_nd"), TEMP_AVATAR("temp_avatar"), TEMP_VIDEO("temp_video"), TEMP_AUDIO("temp_audio"),
        VOICE_CHAT("voice_chat"), IMAGE_CHAT("image_chat"), QR_CODE("qr_code"), BACKUP("backup");

        private String name;

        Directory(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
