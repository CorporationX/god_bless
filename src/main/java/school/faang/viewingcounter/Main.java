package school.faang.viewingcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final VideoManager VIDEO_MANAGER = new VideoManager();
    private static final int COUNT_THREADS = 10;
    private static final int COUNT_OPERATIONS = 100;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(COUNT_THREADS);
    private static final List<String> VIDEOS = List.of(
            "Baby Shark Dance", "Despacito", "See You Again", "Shape of You", "Uptown Funk"
    );
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;
    private static final int SOME_DIVIDER = 3;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT_OPERATIONS; i++) {
            String randomVideo = VIDEOS.get(RANDOM.nextInt(VIDEOS.size()));
            if (i % SOME_DIVIDER == 0) {
                EXECUTOR.submit(() -> executeWithException(() -> VIDEO_MANAGER.getViewCount(randomVideo)));
            }
            EXECUTOR.submit(() -> executeWithException(() -> VIDEO_MANAGER.addView(randomVideo)));
        }
        EXECUTOR.shutdown();
        boolean isTerminated = EXECUTOR.awaitTermination(TIME_EXECUTION, TIME_UNIT);
        if (isTerminated) {
            log.info("All operations is done");
        } else {
            log.warn("Timed out {} {}", TIME_EXECUTION, TIME_UNIT);
            EXECUTOR.shutdownNow();
        }
    }

    private static void executeWithException(RunnableWithException task) {
        try {
            task.run();
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. Name thread: {}\nException: {}\nStack trace: {}",
                    Thread.currentThread().getName(), exception, exception.getStackTrace());
            Thread.currentThread().interrupt();
            EXECUTOR.shutdownNow();
        }
    }
}
