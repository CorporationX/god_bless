package faang.school.godbless.youtube;


import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class YoutubeApproachesTest {
    static int runVideoManagerTest(VideoManagerI videoManager) {
        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(random.nextInt(10));
                    videoManager.addView("100 Layers of ...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return videoManager.getViewCount("100 Layers of ...");
    }

    @Test
    void getViewsSynchronized() {
        VideoManager videoManager = new VideoManager();
        int viewsNumber = runVideoManagerTest(videoManager);
        System.out.println("Synced final value: " + viewsNumber);
        assertEquals(1000, viewsNumber);
    }

    @Test
    void getViewsUnSynchronized() {
        UnsyncedVideoManager videoManager = new UnsyncedVideoManager();
        int viewsNumber = runVideoManagerTest(videoManager);
        System.out.println("UnSynced final value: " + viewsNumber);
        assertNotEquals(1000, runVideoManagerTest(videoManager));

    }

    @Test
    void getViewsConcurrentHashmap() {
        ConcurrentHashmapVideoManager videoManager = new ConcurrentHashmapVideoManager();
        int viewsNumber = runVideoManagerTest(videoManager);
        System.out.println("Concurrent hashmap final value: " + viewsNumber);
        assertEquals(1000, viewsNumber);
    }

}