package school.faang.googlephotosync;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final GooglePhotosAutoUploader UPLOADER = new GooglePhotosAutoUploader();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
    private static final List<String> PHOTOS = List.of(
            "fruits/apple.jpg", "fruits/orange.jpg", "fruits/banana.jpg", "fruits/lemon.jpg",
            "furniture/table.jpg", "furniture/chair.jpg", "furniture/bed.jpg", "furniture/desk.jpg",
            "animals/cat.jpg", "animals/dog.jpg", "animals/rat.jpg", "animals/rabbit.jpg"
    );
    private static final int TIME_EXECUTION = 20;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final List<Runnable> TASKS = List.of(
            () -> executeWithException(UPLOADER::startAutoUpload),
            () -> PHOTOS.forEach(photo -> executeWithException(() -> UPLOADER.onNewPhotoAdded(photo)))
    );
    private static final int STATUS_WITHOUT_ERROR = 0;

    public static void main(String[] args) throws InterruptedException {
        TASKS.forEach(EXECUTOR::submit);
        EXECUTOR.shutdown();
        boolean isTerminated = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT);
        if (!isTerminated) {
            log.info("Forced shutdown auto uploader through {} {}", TIME_EXECUTION, TIME_UNIT);
            System.exit(STATUS_WITHOUT_ERROR);
        }
    }

    private static void executeWithException(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. Thread name: {}\nException: {}\nStack trace: {}",
                    Thread.currentThread().getName(), exception, exception.getStackTrace());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}
