package core.chiennd.View;

import android.os.SystemClock;
import android.view.View;

import core.chiennd.utility.Constants;

public  abstract class COnClickListener implements View.OnClickListener {

    private long mLastClickTime;

    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        long currentClickTime = SystemClock.elapsedRealtime();
        long elapsedTime = currentClickTime - mLastClickTime;
        if (elapsedTime <= Constants.Validate.MIN_CLICK_INTERVAL) {
            return;
        }
        mLastClickTime = currentClickTime;
        onSingleClick(v);
    }
}