package com.chiennd.demo.utility;

public interface Constant {
    interface BroadcastAction {
        String CHIENND = "android.intent.action.chiennd";
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
}
