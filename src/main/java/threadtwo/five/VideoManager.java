package threadtwo.five;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private final Map<String, Video> videos = new HashMap<>();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            videoManager.videos.put(videoId, new Video(videoId, 0));
            System.out.println("Video created with ID: " + videoId);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                EXECUTOR.execute(() -> {
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " started for video index: " + videoId);
                    videoManager.addView(videoId);
                    int view = videoManager.getViewCount(videoId);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " processed video index: " + videoId + ", view count: " + view);
                });
            }
        }
        EXECUTOR.shutdown();
        try {
            if (EXECUTOR.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All videos have been edited");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Video processing was interrupted");
        }
    }

    public synchronized void addView(@NonNull String videoId) {
        Video video = videos.get(videoId);
        if (video == null) {
            throw new IllegalArgumentException("Video not found: " + videoId);
        }
        video.setView(video.getView() + 1);
    }

    public synchronized int getViewCount(@NonNull String videoId) {
        if (videos.containsKey(videoId)) {
            return videos.get(videoId).getView();
        } else {
            throw new IllegalArgumentException("Video ID " + videoId + " does not exist");
        }
    }
}
