package school.faang.google_photosync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(uploader::startAutoUpload);
        executor.submit(() -> {
            uploader.onNewPhotoAdded("src/LadyGaga.png");
            uploader.onNewPhotoAdded("src/P-Diddy.png");
            uploader.onNewPhotoAdded("src/Hasbula.png");
        });
        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Mission Complete");
            } else {
                System.out.println("Something went wrong...");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
