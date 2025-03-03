package school.faang.task_61907;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int EXECUTOR_TIMEOUT = 5;
    public static final int THREADS_COUNT = 10;

    public static void main(String[] args) {
        final GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        final ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);
        final List<String> photosToUpload = getPhotosToUpload();

        photosToUpload.forEach(photoPath -> executor.execute(() -> uploader.onNewPhotoAdded(photoPath)));

        executor.submit(uploader::startAutoUpload);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(EXECUTOR_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Executor terminated successfully or timeout occurred.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error waiting for executor to terminate", e);
            Thread.currentThread().interrupt();
        }
    }

    private static List<String> getPhotosToUpload() {
        return List.of(
                "/photos/1.jpg",
                "/photos/2.jpg",
                "/photos/3.jpg",
                "/photos/4.jpg",
                "/photos/5.jpg",
                "/photos/6.jpg",
                "/photos/7.jpg",
                "/photos/8.jpg",
                "/photos/9.jpg",
                "/photos/10.jpg");
    }
}
