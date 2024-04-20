package youtube;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager manager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            manager.addVideo(new Video("Video " + (i + 1)));
        }

        for (int i = 0; i < (NUM_THREADS); i++) {
            executor.submit(() -> {
                int videoId = RANDOM.nextInt(1, NUM_VIDEOS + 1);
                manager.addView(videoId);
                System.out.println(manager.getViewCount(videoId));
            });
        }


        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        manager.getViewsMap().entrySet()
                .forEach(entry -> System.out.printf("Id: %d\nName: %s\nViews: %d\n=======\n", entry.getKey(), entry.getValue().getName(), entry.getValue().getViews()));

    }
}
