package faang.school.godbless.multithreading.views_youtube;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class YouTube {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> views = IntStream.rangeClosed(1, NUM_VIDEOS).boxed().collect(Collectors.toMap(i -> i, i -> 0));
        VideoManager videoManager = new VideoManager(views);
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            for (int j = 1; j < NUM_THREADS / NUM_VIDEOS; j++) {
                final int id = i;
                service.execute(() -> videoManager.addView(id));
                service.execute(() -> videoManager.getViewCount(id));
            }
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
    }
}
