package core.ch.nd.helper;

import java.util.concurrent.Future;

import core.ch.nd.helper.threadpool.DefaultExecutorSupplier;
import core.ch.nd.helper.threadpool.Priority;
import core.ch.nd.helper.threadpool.PriorityRunnable;

public class ThreadPoolHelper {

    /*
     * Using it for Background Tasks
     */
    public static void doBackgroundTask(final ICallback callback) {
        try {
            DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                    .execute(new Runnable() {
                        @Override
                        public void run() {
                            // do some background work here.
                            if (callback != null) {
                                callback.toExecutor();
                            }
                        }
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Using it for Light-Weight Background Tasks
     */
    public static void doBackgroundTaskLightWeight(final ICallback callback) {
        try {
            DefaultExecutorSupplier.getInstance().forLightWeightBackgroundTasks()
                    .execute(new Runnable() {
                        @Override
                        public void run() {
                            // do some light-weight background work here.
                            if (callback != null) {
                                callback.toExecutor();
                            }
                        }
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Using it for MainThread Tasks
     */
    public static void doMainThreadTask(final ICallback callback) {
        try {
            DefaultExecutorSupplier.getInstance().forMainThreadTasks()
                    .execute(new Runnable() {
                        @Override
                        public void run() {
                            // do some Main Thread work here.
                            if (callback != null) {
                                callback.toExecutor();
                            }
                        }
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * do some task with priority
     */
    public static void doBackgroundTaskWithPriority(Priority priority, final ICallback callback) {
        try {
            DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                    .submit(new PriorityRunnable(priority) {
                        @Override
                        public void run() {
                            // do some background work here at high priority.
                            if (callback != null) {
                                callback.toExecutor();
                            }
                        }
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Get the future of the task by submitting it to the pool
     */
    public static void cancelTask() {
        try {
            Future future = DefaultExecutorSupplier.getInstance().forBackgroundTasks()
                    .submit(new Runnable() {
                        @Override
                        public void run() {
                            // do some background work here.
                        }
                    });
            future.cancel(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public interface ICallback {
        void toExecutor();
    }

}
