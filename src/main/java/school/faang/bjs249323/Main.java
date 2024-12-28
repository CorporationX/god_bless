package school.faang.bjs249323;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(Constants.NUM_THREADS);

        int viewsForVideo = Constants.NUM_THREADS / Constants.NUM_VIDEOS;
        for (int v = 1; v <= Constants.NUM_VIDEOS; v++) {
            String video = "Video" + v;
            for (int t = 1; t <= viewsForVideo; t++) {
                executor.submit(() -> videoManager.addView(video));
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

