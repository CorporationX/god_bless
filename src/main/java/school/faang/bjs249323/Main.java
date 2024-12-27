package school.faang.bjs249323;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        int viewsForVideo = NUM_THREADS / NUM_VIDEOS;
        for (int v = 1; v <= NUM_VIDEOS; v++) {
            String video = "Video" + v;
            for (int t = 1; t <=viewsForVideo ; t++) {
                executor.submit(() -> videoManager.addView(video));
                // System.out.println(video + " views count is: " + videoManager.getViewCount(video));//is not showing actual count data

            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

