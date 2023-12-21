package Synchronization_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        executor.submit(() -> googlePhotosAutoUploader.startAutoUpload());
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(new GooglePhoto().getLink()));
        }
        executor.shutdown();
    }
}
