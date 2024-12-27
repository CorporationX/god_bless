package school.faang.bjs49294;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int THREAD_NUMBER = 10;
    public static final int VIDEOS_NUMBER = 100;
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
        VideoManager videoManager = new VideoManager(new HashMap<>());

        //String video;
        for (int i = 0; i < THREAD_NUMBER; i++) {
            String video = "Video " + RANDOM.nextInt(100, 999);
            for (int j = 0; j < VIDEOS_NUMBER / THREAD_NUMBER; j++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    var views = videoManager.viewCount(video);
                    views.ifPresent((num) -> System.out.println(video + ": " + num));
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error while waiting for shutdown");
            executorService.shutdownNow();
        }
    }
}
