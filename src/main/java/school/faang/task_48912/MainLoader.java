package school.faang.task_48912;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainLoader {
    private static final int NUM_OF_THREADS = 8;
    private static final int TIMEOUT = 15;
    public static void main(String[] args) {

        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);

        executorService.submit(loader::startAutoUpload);
        executorService.submit(() -> loader.onNewPhotoAdded("photo4.jpg"));
        executorService.submit(() -> loader.onNewPhotoAdded("photo5.jpg"));
        executorService.submit(() -> loader.onNewPhotoAdded("photo1.jpg"));
        executorService.submit(() -> loader.onNewPhotoAdded("photo6.jpg"));
        executorService.submit(() -> loader.onNewPhotoAdded("photo7.jpg"));
        executorService.submit(() -> {
            loader.onNewPhotoAdded("photo2.jpg");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            loader.stop();
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("beginning shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("All photos uploaded");
    }
}