package faang.school.godbless.sprint.three.youtube;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String... args) {
        Set<String> videos = new HashSet<>();

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(Constants.NUM_THREADS);

        generateVideos(videos);

        videos.forEach(video -> executor.execute(() -> {
                    for (int i = 0; i < Constants.NUM_THREADS / Constants.NUM_VIDEOS; i++) {
                        videoManager.addView(video);
                    }
                })
        );

        executor.shutdown();

        try {
            if (!executor.awaitTermination(Constants.THREAD_PULL_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
        System.out.println(videoManager.getViewsMap());
        System.out.println("Finish");
    }

    public static void generateVideos(Set<String> videos) {
        for (int i = 0; i < Constants.NUM_VIDEOS; i++) {
            UUID uniqueID = UUID.randomUUID();
            videos.add(uniqueID.toString());
        }
    }
}
