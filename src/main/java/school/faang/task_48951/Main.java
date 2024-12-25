package school.faang.task_48951;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PHOTO_RANGE = 1000;
    private static final int ADD_RANGE = 5;
    private static final int PERIOD = 5;
    private static final int DELAY = 20000;

    public static void main(String[] args) {
        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        Thread thread = new Thread(() -> {
            while (true) {
                loader.startAutoUpload();
            }
        });
        thread.start();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(() -> {
            int addPhotoCount = (int) (Math.random() * ADD_RANGE);
            for (var i = 0; i < addPhotoCount; i++) {
                loader.onNewPhotoAdded("photo_path_" + (int) (Math.random() * PHOTO_RANGE));
            }
        }, 0, PERIOD, TimeUnit.SECONDS);

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            log.warn("Main thread was interrupted", e);
        }

        service.shutdown();
    }
}
