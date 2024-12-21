package school.faang.google_photosync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                uploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.submit(() -> {
            uploader.onNewPhotoAdded("src/LadyGaga.png");
            uploader.onNewPhotoAdded("src/P-Diddy.png");
            uploader.onNewPhotoAdded("src/Hasbula.png");
        });
        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Mission Complete");
        } else {
            System.out.println("Something went wrong...");
        }
    }
}
