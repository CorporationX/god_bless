package school.faang.multithreading.google;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int THREAD_AMOUNT = 2;

    public static void main(String[] args) {
        var autoUploader = new GooglePhotoAutoUploader();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_AMOUNT);

        executorService.scheduleAtFixedRate(autoUploader::startAutoUpload, 0, 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(
                () -> autoUploader.onNewPhotoAdded(UUID.randomUUID().toString()), 0, 6, TimeUnit.SECONDS
        );
    }
}
