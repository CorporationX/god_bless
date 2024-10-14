package school.faang.multithreading.synchron.google.photo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        service.submit(uploader::startAutoUpload);

        service.submit(() -> {
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
            uploader.onNewPhotoAdded("photo4.jpg");
            uploader.onNewPhotoAdded("photo5.jpg");
        });

        service.shutdown();
        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}
