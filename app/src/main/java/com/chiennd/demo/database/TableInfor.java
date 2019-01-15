package com.chiennd.demo.database;

import android.provider.BaseColumns;

public class TableInfor {
    public interface CBaseColumns extends BaseColumns {
        String TYPE = "_type";
        String GROUP_TYPE = "_group_type";

    }

    public interface Message extends CBaseColumns {

        String MSG_ID = "_msg_id";

        String MSG = "_msg";

        String IS_READ = "_is_read";

        String STATUS = "_status";

        String SEND_TIME = "_send_time";

        String RECEIVED_TIME = "_receive_time";

    }

    public interface User extends CBaseColumns {

        String FIRST_NAME = "_first_name";

        String LAST_NAME = "_last_name";

        String BIRTH_DAY = "_birth_day";

        String ID_NO = "_ID_NO";

    }

    public interface Product extends CBaseColumns {

        String NAME = "_name";

    }
}
