package you_toube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video" + i;
            for (int j = 0; j < THREADS_COUNT / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    System.out.println("Video " + video + " number of video views " + videoManager.getViewCount(video));
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5000, TimeUnit.SECONDS)) {
                System.out.println("Threads are not finished");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The counting is over");
    }
}
