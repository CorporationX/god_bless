package school.faang.sprint3.task_49256;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final VideoManager videoManager = new VideoManager();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        IntStream.rangeClosed(1, NUM_VIDEOS).forEach(id -> videoManager.addVideo("VIDEO_ID_" + id));
        IntStream.range(0, NUM_THREADS).parallel().map((idThread) -> (idThread % NUM_VIDEOS) + 1).forEach(
                (idVideo) -> executorService.submit(() -> viewVideo(idVideo))
        );

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void viewVideo(int idVideo) {
        log.info("I am about to view VIDEO_ID_{}", idVideo);
        videoManager.addView(String.format("VIDEO_ID_%d", idVideo));
        int countViews = videoManager.getViewCount(String.format("VIDEO_ID_%d", idVideo));

        log.info("VIDEO_ID_{} - NUM OF VIEWS - {}", idVideo, countViews);
    }
}
