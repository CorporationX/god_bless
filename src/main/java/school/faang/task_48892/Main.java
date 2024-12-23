package school.faang.task_48892;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int photoNumber = i;
            executor.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(String.format("Photo_%d.jpg", photoNumber)));
        }
        Future result = executor.submit(() -> googlePhotosAutoUploader.startAutoUpload());
        while (!result.isDone()) {
            System.out.println("Loading... ");
            Thread.sleep(100);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}