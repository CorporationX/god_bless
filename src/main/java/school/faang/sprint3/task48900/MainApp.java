package school.faang.sprint3.task48900;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final int MAX_PHOTOS = 30;
    private static final int READ_SLEEP_TIME_MSEC = 500;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        Runnable photoReader = new PhotoReader(uploader, MAX_PHOTOS, READ_SLEEP_TIME_MSEC);
        Runnable photoUploader = new PhotoUploader(uploader);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(photoReader, 0, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(photoUploader, 2, 5, TimeUnit.SECONDS);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(READ_SLEEP_TIME_MSEC * MAX_PHOTOS + 5000, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
