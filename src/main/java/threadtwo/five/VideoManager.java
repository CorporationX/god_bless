package threadtwo.five;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static List<Video> videos = new ArrayList<>();
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            videos.add(new Video(videoId, 0));
            System.out.println("Video created with ID: " + videoId);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.execute(() -> {
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " started for video index: " + videoId);
                    addView(videoId);
                    int view = getViewCount(videoId);
                    System.out.println("Thread " + Thread.currentThread().getId() +
                            " processed video index: " + videoId + ", view count: " + view);
                });
            }
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All videos have been edited");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Video processing was interrupted");
        }
    }

    public static synchronized void addView(@NonNull String videoId) {
        int id = Integer.parseInt(videoId);
        if (id <= videos.size()) {
            Video video = videos.get(id);
            video.setView(video.getView() + 1);
        }
    }


    public static synchronized int getViewCount(@NonNull String videoId) {
        int id = Integer.parseInt(videoId);
        if (id <= videos.size()) {
            return videos.get(id).getView();
        }
        throw new IllegalArgumentException("Video ID " + videoId + " does not exist");
    }
}
