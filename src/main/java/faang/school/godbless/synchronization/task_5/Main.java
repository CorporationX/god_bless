package faang.school.godbless.synchronization.task_5;

import faang.school.godbless.synchronization.task_5.util.VideoManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 1000;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);


    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        for (int videoId = 1; videoId <= NUM_VIDEOS; videoId++) {
            videoManager.uploadVideo(String.valueOf(videoId));
        }
        for (int id = 1; id <= NUM_VIDEOS; id++) {
            String videoId = String.valueOf(id);
            for (int index = 0; index < NUM_VIDEOS / NUM_THREADS; index++) {
                EXECUTOR.execute(() -> videoManager.addView(videoId));
            }
        }
        EXECUTOR.shutdown();
        try {
            EXECUTOR.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}