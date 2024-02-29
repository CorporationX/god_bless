package google_photo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        GooglePhoto googlePhoto = new GooglePhoto();

        executorService.execute(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload(googlePhoto);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
        googlePhotosAutoUploader.onNewPhotoAdded("New York city");
        googlePhotosAutoUploader.onNewPhotoAdded("Moscow city");
        googlePhotosAutoUploader.onNewPhotoAdded("Barcelona city");
        googlePhotosAutoUploader.onNewPhotoAdded("Boston city");
        googlePhotosAutoUploader.onNewPhotoAdded("Kazan");

        executorService.execute(() -> {
            System.out.println(googlePhoto.getMyPhoto());
        });
    }
}
