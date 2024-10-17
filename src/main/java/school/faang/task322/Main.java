package school.faang.task322;

import school.faang.task322.photo.GooglePhotosAutoUploader;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader photosUploader = new GooglePhotosAutoUploader();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(photosUploader::startAutoUpload);

        List<String> photos = List.of("photo1", "photo2", "photo3", "photo4", "photo5", "photo6", "photo7");
        executor.submit(() -> {
            for (String string : photos) {
                photosUploader.onNewPhotoAdded(string);
            }
        });

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
