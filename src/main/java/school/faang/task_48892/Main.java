package school.faang.task_48892;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        GooglePhotosAutoUploader googlePhotosAutoUploader = new GooglePhotosAutoUploader();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int photoNumber = i;
            executor.submit(() -> googlePhotosAutoUploader.onNewPhotoAdded(String.format("Photo_%d.jpg", photoNumber)));
        }
        Future result = (Future) executor.submit(() -> googlePhotosAutoUploader.startAutoUpload())
                .get(1, TimeUnit.MINUTES);
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}