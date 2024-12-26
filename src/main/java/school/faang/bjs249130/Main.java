package school.faang.bjs249130;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final long SLEEP_MILLIS = 1000;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(2);
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader(new ArrayList<>());

        executorService.submit(uploader::startAutoUpload);
        executorService.submit(() -> uploader.onNewPhotoAdded("/photos/cats.jpg"));
        shutdown(executorService);
    }

    private static void shutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(SLEEP_MILLIS, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
