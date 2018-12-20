package core.chiennd.View;

import android.os.SystemClock;
import android.view.View;

import core.chiennd.utility.Constants;

public  abstract class COnClickListener implements View.OnClickListener {

    private long lastClickTime;

    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        long currentClickTime = SystemClock.uptimeMillis();
        long elapsedTime = currentClickTime - lastClickTime;
        lastClickTime = currentClickTime;
        if (elapsedTime <= Constants.Validate.MIN_CLICK_INTERVAL) {
            return;
        }
        onSingleClick(v);
    }

    public static View.OnClickListener wrap(final View.OnClickListener onClickListener) {
        return new COnClickListener() {
            @Override
            public void onSingleClick(View v) {
                onClickListener.onClick(v);
            }
        };
    }
}