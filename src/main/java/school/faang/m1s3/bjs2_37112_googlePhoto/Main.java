package school.faang.m1s3.bjs2_37112_googlePhoto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();

        ScheduledExecutorService uploaderService = Executors.newSingleThreadScheduledExecutor();
        ExecutorService addPhotoService = Executors.newSingleThreadExecutor();

        uploaderService.scheduleAtFixedRate(() -> uploader.startAutoUpload(), 0, 5, TimeUnit.SECONDS);

        List<String> newPhotos = new ArrayList<>(List.of("photo1", "photo2", "photo3"));

        newPhotos.forEach(photo ->
                addPhotoService.execute(() -> uploader.addNewPhoto(photo))
        );

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

        newPhotos = new ArrayList<>(List.of("photo4", "photo5", "photo6"));

        newPhotos.forEach(photo ->
                addPhotoService.execute(() -> uploader.addNewPhoto(photo))
        );

        try {
            if (!(uploaderService.awaitTermination(10, TimeUnit.SECONDS)
                    && addPhotoService.awaitTermination(20, TimeUnit.SECONDS))) {
                uploaderService.shutdownNow();
                addPhotoService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}
