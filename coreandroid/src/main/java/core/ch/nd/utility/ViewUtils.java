package core.ch.nd.utility;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class ViewUtils {
    /**
     * animation gone view as IOS
     * @param v
     */
    public static void hideSlideUp(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime,
                                               Transformation t) {

                v.getLayoutParams().height = initialHeight
                        - (int) (initialHeight * interpolatedTime);
                v.requestLayout();

            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        a.setDuration(500);
        v.startAnimation(a);
    }

    /**
     * animation visible view as IOS
     * @param v
     */
    public static void showSlideDown(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targtetHeight = v.getMeasuredHeight();
        if (v.isShown()) {
            hideSlideUp(v);
        } else {
            v.getLayoutParams().height = 0;
            v.setVisibility(View.VISIBLE);
            Animation a = new Animation() {
                @Override
                protected void applyTransformation(float interpolatedTime,
                                                   Transformation t) {
                    v.getLayoutParams().height = (int) (targtetHeight * interpolatedTime);
                    v.requestLayout();
                }

                @Override
                public boolean willChangeBounds() {
                    return true;
                }
            };
            a.setDuration(500);
            v.startAnimation(a);
        }
    }
}
