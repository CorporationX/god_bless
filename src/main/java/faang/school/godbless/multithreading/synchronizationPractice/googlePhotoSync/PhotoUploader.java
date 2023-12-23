package faang.school.godbless.multithreading.synchronizationPractice.googlePhotoSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhotoUploader {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo1.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo2.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo3.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo4.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo5.jpg");
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo6.jpg");
        });

        executorService.shutdown();
    }
}
