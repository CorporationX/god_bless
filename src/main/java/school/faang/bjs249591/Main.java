package school.faang.bjs249591;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws Exception {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "test" + i;
            int n = NUM_THREADS / NUM_VIDEOS;
            for (int j = 0; j < n; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video " + videoId + " просмотров: " + videoManager.getViewCount(videoId));
                });
            }
        }


        executorService.shutdown();
        try {
            boolean result = executorService.awaitTermination(2, TimeUnit.MINUTES);
            if (!result) {
                System.out.println("Process terminated due to thread failure");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        System.out.println(videoManager.getViewsMap());
    }

}
