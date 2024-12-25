package school.faang.sprint_3.task_48990;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int AWAIT_TIME_MINUTES = 1;

    public static void main(String[] args) {
        GooglePhotosAutoUploader googlePhotos = new GooglePhotosAutoUploader();
        List<String> photos = List.of("photo1.jpg", "photo2.jpg", "photo3.jpg", "photo4.jpg");

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            for (int i = 0; i <= NUM_THREADS; i++) {
                executor.submit(googlePhotos::startAutoUpload);

                executor.submit(() -> {
                    for (String photo : photos) {
                        googlePhotos.onNewPhotoAdded(photo);
                    }
                });

            }

            executor.shutdown();
            if (executor.awaitTermination(AWAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (Exception e) {
            log.error("Error message: ", e);
        }
    }
}
