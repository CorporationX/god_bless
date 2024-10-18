package school.faang.googlephoto;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_COUNT = 2;
    private static final int UPLOAD_DELAY = 5;

    public static void main(String[] args) {
        GooglePhotoAutoUploader uploader = new GooglePhotoAutoUploader();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_COUNT);
        executor.scheduleAtFixedRate(uploader::startAutoUpload, 0, UPLOAD_DELAY, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(
                () -> uploader.onNewPhotoAdded("C://new_photo.png"), 0, 1, TimeUnit.SECONDS
        );
        executor.schedule(executor::shutdown, 20, TimeUnit.SECONDS);

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
