import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs249312.VideoManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManagerTest {
    @Test
    void testInitialViewCounterIsZero() {
        VideoManager videoManager = new VideoManager();
        Assertions.assertEquals(0, videoManager.getViewCounter("Video 1"));
    }

    @Test
    void testAddSingleView() {
        VideoManager videoManager = new VideoManager();
        videoManager.addView("Video 1");
        Assertions.assertEquals(1, videoManager.getViewCounter("Video 1"));
    }

    @Test
    void testAddMultipleView() {
        VideoManager videoManager = new VideoManager();
        videoManager.addView("Video 1");
        videoManager.addView("Video 1");
        videoManager.addView("Video 1");

        Assertions.assertEquals(3, videoManager.getViewCounter("Video 1"));
    }

    @Test
    void testAddViewForMultipleVideo() {
        VideoManager videoManager = new VideoManager();
        videoManager.addView("Video 1");
        videoManager.addView("Video 2");
        videoManager.addView("Video 2");

        Assertions.assertEquals(1, videoManager.getViewCounter("Video 1"));
        Assertions.assertEquals(2, videoManager.getViewCounter("Video 2"));
    }

    @Test
    void testConcurrentAddView() throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        int countTread = 10;
        int countViewForEveryoneThread = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(countTread);

        for (int i = 0; i < countTread; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < countViewForEveryoneThread; j++) {
                    videoManager.addView("Video 1");
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        Assertions.assertEquals(countTread * countViewForEveryoneThread, videoManager.getViewCounter("Video 1"));
    }

}
