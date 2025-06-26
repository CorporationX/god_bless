package school.faang.score_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 2;
    private static final int NUM_VIDEOS = 6;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();
        String[] films = new String[]{
                "Terminator", "Tarzan", "Anaconda", "Terminator 2", "Pineapple express", "XXX"
        };
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                int finalI = i;
                executorService.submit(() -> videoManager.addView(films[finalI]));
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < NUM_VIDEOS; i++) {
            System.out.printf("Фильм: %s посмотрели %d раз.\n", films[i], videoManager.getViewCount(films[i]));
        }
    }
}