package school.faang.youtubecounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ViewsRunner {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video#" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> videoManager.addView(video));
            }
        }
        executor.shutdown();
        int second = 5;
        try {
            if (!executor.awaitTermination(second, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error(e.getMessage());
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video#" + i;
            System.out.println("Video: " + video + " Views:" + videoManager.getViewCount(video));
        }

    }

}
