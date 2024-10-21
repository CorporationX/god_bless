package school.faang.synchphoto;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Application {
    private static final int THREAD_QUANTITY = 2;
    private static final int INITIAL_DELAY_UPLOAD_PHOTO = 0;
    private static final int INITIAL_DELAY_NEW_PHOTO = 3;
    private static final int PERIOD_UPLOAD_PHOTO = 2;
    private static final int PERIOD_NEW_PHOTO = 1;


    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_QUANTITY);

        executorService.scheduleAtFixedRate(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                log.error("startAutoUpload thread crashed");
                e.printStackTrace();
            }
        }, INITIAL_DELAY_UPLOAD_PHOTO, PERIOD_UPLOAD_PHOTO, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(() ->
            googlePhotosAutoUploader.onNewPhotoAdded("URL: " + LocalTime.now()
            ), INITIAL_DELAY_NEW_PHOTO, PERIOD_NEW_PHOTO, TimeUnit.SECONDS);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                log.info("!!! OK !!!");
            } else {
                executorService.shutdownNow();
                log.error("executorService.shutdownNow()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
