package faang.school.godbless.youtubecounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            Video video = new Video("Video_" + i);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> videoManager.addView(video.getVideoId()));
                executorService.execute(() -> videoManager.getViewCount(video.getVideoId()));
            }
        }
        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        System.out.println("end");
    }
}
