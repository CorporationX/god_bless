package school.faang.youtubeviews;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            for (int k = 0; k < NUM_THREADS; k++) {
                String videoId = String.valueOf(i);
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    log.info("Video {} has {} view(s)",
                            videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
    }
}
