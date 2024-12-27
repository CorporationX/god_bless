package school.faang.sprint3.bjs_49172;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int COUNT_THREADS = 21;
    private static final int NUMBER_OF_VIDEOS = 5;
    private static final int TIME_OUT = 1;

    public static void main(String[] args) {

        List<String> videos = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VIDEOS; i++) {
            videos.add("video_n" + i);
        }

        VideoManager youtube = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

        videos.forEach(video -> {
            for (int i = 0; i < COUNT_THREADS / NUMBER_OF_VIDEOS; i++) {
                executor.submit(() -> {
                    youtube.addView(video);
                    log.info("{} has been viewed {} times", video, youtube.getViewCount(video));
                });
            }
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                log.warn("Not all threads stopped by themselves");
            }
        } catch (InterruptedException e) {
            log.error("Thread forced to stopped");
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdownNow();
        }
    }
}
