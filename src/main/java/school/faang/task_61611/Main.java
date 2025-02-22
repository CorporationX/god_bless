package school.faang.task_61611;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final int THREAD_TIMEOUT = 1;
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            String video = "video " + i;
            for (int j = 0; j < NUM_VIDEOS; j++) {
                pool.execute(() -> {
                    manager.addView(video);
                    LOG.info("Video {} views: {}", video, manager.getViewCount(video));
                });
            }
        }

        pool.shutdown();
        try {
            if (!pool.awaitTermination(THREAD_TIMEOUT, TimeUnit.MINUTES)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
            LOG.info("Thread's timeout is out", e);
        }
    }
}
