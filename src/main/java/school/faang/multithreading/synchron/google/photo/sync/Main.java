package school.faang.multithreading.synchron.google.photo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int THREAD_POOL_SIZE = 2;
    private final static int TIME_FOR_SLEEP = 500;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        service.submit(uploader::startAutoUpload);

        service.submit(() -> {
            try {
                Thread.sleep(TIME_FOR_SLEEP);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            uploader.onNewPhotoAdded("photo1.jpg");
            uploader.onNewPhotoAdded("photo2.jpg");
            uploader.onNewPhotoAdded("photo3.jpg");
            uploader.onNewPhotoAdded("photo4.jpg");
            uploader.onNewPhotoAdded("photo5.jpg");
        });
    }
}
