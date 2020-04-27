package com.chiennd.ex.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    /**
     * Check network connection
     *
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null) {
            return false;
        }
        if (!i.isConnected()) {
            return false;
        }
        return i.isAvailable();
    }
}
