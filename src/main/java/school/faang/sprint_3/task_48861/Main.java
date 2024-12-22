package school.faang.sprint_3.task_48861;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AMOUNT_OF_PHOTOS_TO_UPLOAD = 100;
    private static final int NUMBER_OF_THREADS = 2;
    private static final int AWAIT_DELAY = 5;

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader(new ArrayList<>());
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        executorService.submit(googlePhotosAutoUploader::startAutoUpload);
        executorService.submit(() -> {
            for (int i = 1; i <= AMOUNT_OF_PHOTOS_TO_UPLOAD; i++) {
                googlePhotosAutoUploader.onNewPhotoAdded("Photo" + i);
            }
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.SECONDS)) {
                System.out.println("Await termination timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
