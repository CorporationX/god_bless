package faang.school.godbless.multithreading_synchronization.task_2;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GooglePhotosController {

    private static final int THREAD_COUNT = 2;
    private static final int AWAIT_TERMINATION_TIME = 10;

    public static void main(String[] args) {
        final List<String> photos = getPhotos();
        final GooglePhotosAutoUploader uploader = new GooglePhotosAutoUploader();
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        executor.submit(uploader::startAutoUpload);
        executor.submit(() -> photos.forEach(uploader::onNewPhotoAdded));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread was interrupted while waiting for termination " + e);
        }
    }

    private static List<String> getPhotos() {
        return List.of(
                "something.jpg",
                "graduation_day.jpg",
                "beach.jpg",
                "moon.jpg",
                "vacation.jpg"
        );
    }
}
