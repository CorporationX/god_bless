package faang.school.godbless.task.multithreading.youtube.views.counter;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 20;
    public static final int TIME_OUT = 5;

    private static final VideoManager videoManager = new VideoManager();
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
    private static List<String> videoId;

    public static void main(String[] args) {
        videoId = createVideoId();
        videoId.forEach(id -> IntStream.range(0, NUM_THREADS / NUM_VIDEOS)
                .forEach(i -> executor.submit(() -> watchVideo(id))));
        executor.shutdown();
        waitEnd(executor, videoId);
    }

    private static void waitEnd(ExecutorService executor, List<String> videoId) {
        try {
            if (executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS)) {
                printAllViews(videoId);
            } else {
                log.info("Видео записи не успели воспроизвестись за {} секунд", TIME_OUT);
            }
        } catch (InterruptedException exception) {
            log.error("Interrupted exception: {}", exception.getMessage());
        }
    }

    private static void watchVideo(String videoId) {
        videoManager.addView(videoId);
        videoManager.getViewCount(videoId)
                .ifPresent(view -> log.info("Воспроизведено виде с id: {}, просмотров: {}", videoId, view));
    }

    private static List<String> createVideoId() {
        return IntStream
                .rangeClosed(1, NUM_VIDEOS)
                .mapToObj(i -> "Video_" + i)
                .toList();
    }

    private static void printAllViews(List<String> videos) {
        videos.forEach(videoId -> videoManager.getViewCount(videoId)
                .ifPresent(view -> log.info("id: {}, просмотров: {}", videoId, view)));
    }
}
