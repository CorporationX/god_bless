package school.faang.task_49402;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10; i++) {
            String videoId = "video_" + i;

            for (int j = 0; j < 100 / 10; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println(videoId + " имеет " + videoManager.getViewCount(videoId) + " просмотров");
                });
            }
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
