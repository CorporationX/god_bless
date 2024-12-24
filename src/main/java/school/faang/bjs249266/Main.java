package school.faang.bjs249266;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static final int NUMBER_THREADS = 100;
    public static final int NUMBER_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);

        for (int i = 0; i < NUMBER_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUMBER_THREADS / NUMBER_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    System.out.println("Video " + videoId + " просмотров: " + manager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            log.error("Error interrupted exception! {}", String.valueOf(ex));
        }
    }
}
