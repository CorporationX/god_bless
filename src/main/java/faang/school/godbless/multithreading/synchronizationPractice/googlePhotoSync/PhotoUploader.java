package faang.school.godbless.multithreading.synchronizationPractice.googlePhotoSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PhotoUploader {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> startUploadFuture = executorService.submit(() -> {
            try {
                googlePhotosAutoUploader.startAutoUpload();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<?> addPhotoFuture = executorService.submit(() -> {
            googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo1.jpg");
            try {
                Thread.sleep(2000);
                googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo2.jpg");
                googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo3.jpg");
                googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo4.jpg");
                Thread.sleep(4000);
                googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo5.jpg");
                googlePhotosAutoUploader.onNewPhotoAdded("C:\\Users\\user\\Pictures\\photo6.jpg");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();

        while (true) {
            if (addPhotoFuture.isDone() && googlePhotosAutoUploader.getPhotosToUpload().isEmpty()) {
                startUploadFuture.cancel(true);
                break;
            }
        }
    }
}
