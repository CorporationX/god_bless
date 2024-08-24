package faang.school.godbless.BJS2_24407;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;
    private static final VideoManager videoManager = new VideoManager();
    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            videoManager.addVideo(videoId);
            System.out.println("Video " + videoId + " added");

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video " + videoId + " views: " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All videos and views have been added");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.error(e.getMessage());
        }
    }
}
