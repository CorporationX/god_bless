package school.faang.BJS2_37203_GooglePhotoSync;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int UPLOAD_ACTION_RATE = 6;
    private static final int ADD_PHOTO_ACTION_RATE = 2;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Runnable uploadAction = uploader::startAutoUpload;
        Runnable addPhotoAction =
                () -> uploader.onNewPhotoAdded(
                        String.format("photo-%d.jpg", ThreadLocalRandom.current().nextInt(1, 1_000))
                );
        service.scheduleAtFixedRate(uploadAction, 0, UPLOAD_ACTION_RATE, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(addPhotoAction, 0, ADD_PHOTO_ACTION_RATE, TimeUnit.SECONDS);

        service.schedule(service::shutdown, 25, TimeUnit.SECONDS);
        try {
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Timeout! Shutting down executor service!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new IllegalStateException("Main thread was interrupted while waiting for thread pool shutdown.");
        }

        System.out.println("Main thread finished its execution!");
    }
}
