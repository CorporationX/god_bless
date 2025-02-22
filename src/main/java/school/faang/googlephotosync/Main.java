package school.faang.googlephotosync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> uploader.startAutoUpload());
        executor.execute(() -> {
            uploader.onNewPhotoAdded("photo01.jpg");
            uploader.onNewPhotoAdded("photo02.jpg");
            uploader.onNewPhotoAdded("photo03.jpg");
            uploader.onNewPhotoAdded("photo04.jpg");
            uploader.onNewPhotoAdded("photo05.jpg");
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}