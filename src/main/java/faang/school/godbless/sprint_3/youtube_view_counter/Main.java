package faang.school.godbless.sprint_3.youtube_view_counter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 1000;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            // Вот тут по условию должно быть NUM_THREADS / NUM_VIDEOS,
            // мне кажется это нелогично, так как видео у нас точно будет больше чем потов.
            for (int j = 0; j < NUM_VIDEOS / NUM_THREADS; j++) {
                int videoId = i;
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    log.info("VideoId -> {}, views -> {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        log.info("Finish!");
    }
}