package school.faang.youtubeviews;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 2;
    private static final List<String> NUM_VIDEOS = List.of(
            "Video1",
            "Video2",
            "Video3",
            "Video1",
            "Video1",
            "Video3"
    );

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        NUM_VIDEOS.forEach(video -> executor.execute(() -> videoManager.addView(video)));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        NUM_VIDEOS.stream()
                .distinct()
                .forEach(video ->
                        log.info("Количество просмотров для видео {} == {}", video, videoManager.getViewCount(video)));
    }
}
