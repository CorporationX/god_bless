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

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService1 = Executors.newFixedThreadPool(4);

        executorService.submit(() -> googlePhotosAutoUploader.startAutoUpload());
        photos.forEach(e -> executorService1.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(e)));

        executorService.shutdown();
        executorService1.shutdown();
        try {
            if (!executorService1.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService1.shutdownNow();
            }
            googlePhotosAutoUploader.stopFlag();
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("все сделал");
    }
}