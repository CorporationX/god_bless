package faang.school.godbless.YouTube;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 50;
    private final static int NUM_VIDEOS = 10;

    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Map<String, Integer> viewsMap = new HashMap<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            viewsMap.put(String.format("%d", i), i * 10);
        }
        VideoManager videos = new VideoManager(viewsMap);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 1; j <= NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(new RunnableForYouTube(videos,String.valueOf(i)));
            }
        }
        executor.shutdown();
        Thread.sleep(15000);
        executor.awaitTermination(10, TimeUnit.MINUTES);
    }
}
