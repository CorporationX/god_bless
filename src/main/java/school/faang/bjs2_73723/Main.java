package school.faang.bjs2_73723;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREADS = 5;
    private static final int TIMEOUT = 35;

    public static void main(String[] args) throws InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        IntStream.range(0, 100).boxed().forEach(index -> {
            executorService.execute(googlePhotosAutoUploader::startAutoUpload);
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("First path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Second path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Third path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Fourth path"));
            executorService.execute(() -> googlePhotosAutoUploader.onNewPhotoAdded("Fifth path"));
        });
        executorService.shutdown();
        if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
            System.out.println("Forceful shutdown");
        }
    }
}
