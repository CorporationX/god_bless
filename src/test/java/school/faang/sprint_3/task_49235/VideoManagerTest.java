package school.faang.sprint_3.task_49235;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoManagerTest {
    VideoManager videoManager;

    @BeforeEach
    void setUp() {
        videoManager = new VideoManager();
    }

    @RepeatedTest(5)
    void testAddViewBaseCase() {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        try {
            for (int i = 0; i < NUM_VIDEOS; i++) {
                final String videoId = "video" + i;
                for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                    executor.submit(() -> videoManager.addView(videoId));
                }
            }

            executor.shutdown();
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                throw new RuntimeException("Executor did not terminate in the specified time.");
            }

            for (int i = 0; i < NUM_VIDEOS; i++) {
                assertEquals(11, videoManager.getViewCount("video" + i), "Video " + i);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Task execution was interrupted", e);
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }

    }
}
