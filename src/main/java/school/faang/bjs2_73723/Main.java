package school.faang.bjs2_73723;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(new ArrayList<>());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(googlePhotosAutoUploader::startAutoUpload);
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("First path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Second path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Third path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Fourth path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Fifth path"));
        }
        executorService.shutdown();
        if (!executorService.awaitTermination(35, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
            System.out.println("Forceful shutdown");
        }
    }
}
