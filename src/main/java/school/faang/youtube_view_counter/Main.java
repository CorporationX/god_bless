package school.faang.youtube_view_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {

    private static final int NUM_THREADS = 10; //количество потоков на видео
    private static final int NUM_VIDEOS = 5;   //количество видео

    public static void main(String[] args) {

        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_VIDEOS).forEach(i -> {
            String videoId = "video" + i;
            IntStream.range(0, NUM_THREADS).forEach(j ->
                    executor.submit(() -> {
                        manager.addView(videoId);
                        System.out.println("Video " + videoId + " просмотров: " + manager.getViewCount(videoId));
                    })
            );
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("\nИтоговые просмотры всех видео:");
        manager.getViewsMap().forEach((videoId, count) ->
                System.out.println(videoId + " -> " + count)
        );
    }
}