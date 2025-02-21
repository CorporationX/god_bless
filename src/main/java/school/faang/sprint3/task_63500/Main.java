package school.faang.sprint3.task_63500;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 20;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        IntStream.range(0, NUM_VIDEOS)
                .forEach(num -> IntStream.range(0, NUM_THREADS)
                        .forEach(thread -> EXECUTOR.submit(() -> videoManager.addView("video" + num))));


        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(1, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }

        System.out.printf("Общее кол-во просмотров %d из %d", videoManager.getAllViewCount(), NUM_VIDEOS * NUM_THREADS);
    }
}
