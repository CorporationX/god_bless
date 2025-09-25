package school.faang.google_photo_sync_bjs2_90475;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GoogleMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            String[] photos = {"photo1.jpg", "photo2.jpg", "photo3.jpg", "photo4.jpg"};

            for (String photo : photos) {
                googlePhotosAutoUploader.onNewPhotoAdded(photo);
            }
        });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("все сделал");
    }
}