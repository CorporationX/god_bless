package faang.school.godbless.youtube;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    private static final long SLEEP_SECONDS = 5000L;

    private static final List<String> videos = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String nameOfVideo = "Viral video - " + i;
            videos.add(nameOfVideo);
            videoManager.addView(nameOfVideo);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        videos.forEach(video -> {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.execute(() -> {
                    videoManager.addView(video);
                    System.out.println("Video " + video + " has " + videoManager.getViewCount(video) + " views");
                });
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(SLEEP_SECONDS, TimeUnit.SECONDS);

        Thread.sleep(SLEEP_SECONDS);

        System.out.println("Map keys size " + videoManager.getViewsMap().size());
        System.out.println("Map values " + videoManager.getViewsMap().values());
        System.out.println("Map sum of keys " + videoManager.getViewsMap().values().stream()
                .mapToInt(Integer::intValue)
                .sum());
    }
}
