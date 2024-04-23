package YouTubeViewCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final List<String> videoIDs = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        generateId();

        for (String videoID : videoIDs) {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                service.execute(() -> videoManager.addView(videoID));
                service.execute(() -> System.out.println(videoID + " -> " + videoManager.getViewCount(videoID)));
            }
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("ready");
    }

    private static void generateId() {
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoIDs.add("new_video_" + (i + 1));
        }
    }
}
