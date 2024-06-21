package faang.school.godbless.synchronization.youtube;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VideoManager {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videoIds = IntStream.rangeClosed(1, NUM_VIDEOS)
                .boxed()
                .map(i -> "videouid" + i)
                .toList();

        videoIds.forEach(videoId ->
                IntStream.range(0, NUM_THREADS / NUM_VIDEOS).forEach(i ->
                        executorService.execute(() -> {
                            videoManager.addView(videoId);
                            System.out.println(videoId + ": " + videoManager.getViewCount(videoId));
                        })));

        executorService.shutdown();
        executorService.awaitTermination(120, TimeUnit.SECONDS);
    }

    public void addView(String videoId) {
        synchronized (viewsMap) {
            Integer views = viewsMap.get(videoId);
            if (views == null) {
                views = 0;
            }
            viewsMap.put(videoId, ++views);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
