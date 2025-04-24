package school.faang.bjs2_73767;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.bjs2_73767.VideoIdCounter.getNextVideoId;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 300;
    private static final int MAX_EXPECTATION = 60;
    private static final List<String> VIDEOS = new ArrayList<>();

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            VIDEOS.add(getNextVideoId());
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = VIDEOS.get(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    int countViews = videoManager.getViewCount(videoId);
                    log.info("Count views for video with id {} is {}", videoId, countViews);
                });
            }
        }

        executorService.shutdown();
        try {
            boolean isClose = executorService.awaitTermination(MAX_EXPECTATION, TimeUnit.SECONDS);
            if (!isClose) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("thread stoppage error");
            executorService.shutdownNow();
        }

    }
}
