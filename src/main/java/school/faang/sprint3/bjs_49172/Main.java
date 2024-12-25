package school.faang.sprint3.bjs_49172;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final int countThreads = 20;
        final int numberOfVideo = 5;
        int timeOut = 1;

        Random random = new Random();
        List<String> videos = new ArrayList<>();
        for (int i = 0; i < numberOfVideo; i++) {
            videos.add("video" + random.nextInt(100));
        }

        VideoManager youtube = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(countThreads);

        videos.forEach(video -> {
            for (int i = 0; i < countThreads / numberOfVideo; i++) {
                executor.submit(() -> {
                    youtube.addView(video);
                    log.info("{} has been viewed {} times", video, youtube.getViewCount(video));
                });
            }
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(timeOut, TimeUnit.SECONDS)) {
                log.warn("Not all threads stopped by themselves");
            }
        } catch (InterruptedException e) {
            log.error("Threads forced to stopped");
        } finally {
            executor.shutdownNow();
        }
    }
}
