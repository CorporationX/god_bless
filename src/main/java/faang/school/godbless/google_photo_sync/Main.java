package faang.school.godbless.google_photo_sync;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        List<String> photos = List.of("path1", "path2", "path3", "path4", "path5", "path6", "path7");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable addPhotos = () -> {
            for (int i = 8; i <= 30; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded("photo" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                executorService.execute(googlePhotosAutoUploader::startAutoUpload);
            }
        };

        for (int i = 0; i < photos.size(); i++){
            googlePhotosAutoUploader.onNewPhotoAdded(photos.get(i));
        }

        executorService.execute(googlePhotosAutoUploader::startAutoUpload);
        executorService.execute(addPhotos);


        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
