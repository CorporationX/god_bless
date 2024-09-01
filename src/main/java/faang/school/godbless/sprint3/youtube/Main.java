package faang.school.godbless.sprint3.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final long TIMEOUT = 5L;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.rangeClosed(1, NUM_VIDEOS)
                .mapToObj(i -> "VideoId_" + i)
                .forEach(videoId ->
                    IntStream.rangeClosed(1, NUM_THREADS / NUM_VIDEOS)
                            .forEach(i ->
                                executor.submit(() -> {
                                    synchronized(manager) {
                                        manager.addView(videoId);
                                        System.out.printf("[%s] - Views for %s: %d%n", Thread.currentThread().getName(), videoId, manager.getViewCount(videoId));
                                    }
                                }, "THREAD-" + videoId + "_"+ i)
                            )
                );

        executor.shutdown();
        long startTime = System.currentTimeMillis();
        try {
            while(!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                if (System.currentTimeMillis() - startTime > TIMEOUT) {
                    System.out.println("Timeout reached: " + TIMEOUT);
                    executor.shutdownNow();
                } else {
                    System.out.println("Tasks being processed...");
                }
            }
        } catch(InterruptedException e) {
            throw new RuntimeException("Thread interrupted!");
        }
    }
}
