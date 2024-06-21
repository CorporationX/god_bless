package faang.school.godbless.multithreading.youtube;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT_SECONDS = 3;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        List<Video> videos = Video.addVideoToList(NUM_VIDEOS);
        videoManager.UploadVideo(videos);
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (Video video : videos) {
            videoManager.addViews(video);
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.submit(() -> videoManager.addViews(video));
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error while shutting down");
        }
    }


}
