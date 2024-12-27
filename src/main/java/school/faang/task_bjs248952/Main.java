package school.faang.task_bjs248952;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService autoUploader = Executors.newFixedThreadPool(1);
        autoUploader.execute(uploader::startAutoUpload);
        ExecutorService addPhotosService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            final int numberOfPhoto = i;
            addPhotosService.execute(() -> uploader.onNewPhotoAdded("Фото " + numberOfPhoto));
        }

        autoUploader.shutdown();
        addPhotosService.shutdown();

        try {
            if (!autoUploader.awaitTermination(5, TimeUnit.SECONDS) || !addPhotosService
                    .awaitTermination(5, TimeUnit.SECONDS)) {
                autoUploader.shutdownNow();
                addPhotosService.shutdownNow();
            }
        } catch (InterruptedException e) {
            autoUploader.shutdownNow();
            addPhotosService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}