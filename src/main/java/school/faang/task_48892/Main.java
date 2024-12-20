package school.faang.task_48892;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int photoNumber = i;
            executor.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(String.format("Photo_%d.jpg", photoNumber)));
        }
        executor.submit(() -> googlePhotosAutoUploader.startAutoUpload());
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(executor.isTerminated());
        System.out.println(executor.isShutdown());
    }
}