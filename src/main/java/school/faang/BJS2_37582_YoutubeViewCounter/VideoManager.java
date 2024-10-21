package school.faang.BJS2_37582_YoutubeViewCounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class VideoManager {
    private static final int AWAIT_TERMINATION_TIME = 5;
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    private ConcurrentHashMap<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new ConcurrentHashMap<>();
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int id = 0; id < NUM_VIDEOS; id++) {
            String videoId = String.format("/id/%d", id);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("The number of views of the '{}' video - {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                log.info("Video manager finished its work correctly!");
            } else {
                log.warn("Video manager did not finish its work on time. Force shutting down executor!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted while waiting for video manager to finish its tasks!", e);
        }
    }

    public void addView(String videoId) {
        Integer viewsCount = viewsMap.merge(videoId, 1, Integer::sum);
        log.info("The number of views of the video '{}' has been increased by 1! Now its value is {}", videoId, viewsCount);
    }

    public Integer getViewCount(String videoId) {
        log.info("The number of views of the '{}' video was requested", videoId);
        return viewsMap.getOrDefault(videoId, 0);
    }
}
