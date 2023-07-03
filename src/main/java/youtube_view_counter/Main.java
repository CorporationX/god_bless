package youtube_view_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoID = "Video №" + i;
            int views = NUM_THREADS / NUM_VIDEOS;
            for (int j = 0; j < views; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoID);
                    System.out.println("View count of " + videoID + " - " +
                            videoManager.getViewCount(videoID));
                });
            }
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoID = "Video №" + i;
            int viewCount = videoManager.getViewCount(videoID);
            System.out.println(videoID + " has been watched " + viewCount + " times");
        }
    }
}
