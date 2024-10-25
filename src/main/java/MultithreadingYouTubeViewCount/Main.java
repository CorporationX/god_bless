package MultithreadingYouTubeViewCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        Map<String, Integer> viewsMap = new HashMap<>();
        List<Video> videoList = new ArrayList<>();

        VideoManager videoManager = new VideoManager(viewsMap);

        ExecutorService exec = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            videoList.add(new Video(videoId));

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                exec.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("The number of views for the video " +videoId + " is " + videoManager.getViewCount(videoId));
                });
            }
        }

        try {
            exec.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();

        System.out.println("================================================");

        for (Video video : videoList) {
            System.out.println("The video (" + video.getId() + "): " + videoManager.getViewCount(video.getId()));
        }
    }
}
