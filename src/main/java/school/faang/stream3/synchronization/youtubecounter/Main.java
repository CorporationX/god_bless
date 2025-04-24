package school.faang.stream3.synchronization.youtubecounter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        List<String> videos = Arrays.asList(
                "Cute puppies",
                "Java concurrency",
                "Knitting a scarf",
                "How to repair a car",
                "What means an acute pain in stomach");

        videos.forEach(videoManager::addVideo);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = videos.get(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Someone is watching a video - %s\n", videoId);
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (String video : videos) {
            System.out.printf("%s посмотрели %d раз\n", video, videoManager.getViewCount(video));
        }
    }
}
