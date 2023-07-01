package faang.school.godbless.thirdSprint.YouTube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        Map<Integer, Video> videos = new HashMap<>();
        Map<Video, Integer> viewsMap = new HashMap<>();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            Video video = new Video(("Some name #" + i), i);
            viewsMap.put(video, 0);
            videos.put(video.videoId(), video);
        }
        manager.setViewsMap(viewsMap);
        manager.setVideos(videos);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            int videoId = i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.execute(() -> {
                    synchronized (manager) {
                        manager.addView(videoId);
                        int viewCount = manager.getViewCount(videoId);
                        System.out.println("Video " + videos.get(videoId).videoName() + " has " + viewCount + " views");
                    }
                });
            }
        }
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All views have been counted");
    }
}
