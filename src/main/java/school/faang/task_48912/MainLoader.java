package school.faang.task_48912;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainLoader {
    public static void main(String[] args) {
        GooglePhotosAutoUploader loader = new GooglePhotosAutoUploader();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(loader::startAutoUpload);
        executorService.submit(() -> {
            loader.onNewPhotoAdded("photo4.jpg");
            loader.onNewPhotoAdded("photo5.jpg");
            loader.onNewPhotoAdded("photo1.jpg");
            loader.onNewPhotoAdded("photo2.jpg");
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(7, TimeUnit.SECONDS)) {
                System.out.println("beginning shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            executorService.shutdownNow();
        }

        System.out.println("All photos uploaded");
    }
}