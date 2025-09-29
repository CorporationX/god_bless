package school.faang.google_photo_sync_bjs2_90475;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GoogleMain {
    public static void main(String[] args) {
        List<String> photos = new ArrayList<>();
        photos.add("photo1.jpg");
        photos.add("photo2.jpg");
        photos.add("photo3.jpg");
        photos.add("photo4.jpg");

        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() ->
                googlePhotosAutoUploader.startAutoUpload());
        photos.stream()
                        .forEach(e -> executorService.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(e)));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("все сделал");
    }
}