package com.ch.nd.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ch.nd.utility.Constant;

public class CBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case Intent.ACTION_BOOT_COMPLETED:
                break;
            case Constant.BroadcastAction.CHIENND:
                break;
        }


    }
}
