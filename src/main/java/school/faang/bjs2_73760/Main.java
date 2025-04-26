package school.faang.bjs2_73760;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    private static final int NUM_PHOTOS = 20;

    private static final int NUM_THREADS = 2;
    private static final int MAX_EXPECTATION = 60;

    public static void main(String[] args) {
        GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        executorService.execute(() -> {
            for (int i = 0; i < NUM_PHOTOS; i++) {
                uploader.onNewPhotoAdded(PhotosCounter.getNextPhoto());
            }
        });
        executorService.execute(uploader::startAutoUpload);
        gracefullyShutdown(executorService);
    }

    private static void gracefullyShutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            executorService.shutdownNow();
        }
    }
}
