package school.faang.multithreading.synchronize.bjs2_90441;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();

        executorService.execute(googlePhotosAutoUploader::startAutoUpload);
        executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("New photos"));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}