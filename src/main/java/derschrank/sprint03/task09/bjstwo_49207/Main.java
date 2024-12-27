package derschrank.sprint03.task09.bjstwo_49207;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int DEFAULT_THREADS_FOR_ONE_VIDEO = 100;
    private static final int DEFAULT_TIMES_THREADS_FOR_ONE_VIDEO = 2;
    private static final int DEFAULT_SIZE_POOL = 20;
    private static final int DEFAULT_AWAIT_TIME_SECONDS = 10;
    private static final int DEFAULT_VIDEOS = 10;


    public static void main(String[] args) {
        VideoManagerInterface videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_SIZE_POOL);

        doViewsInThreads(executor, videoManager);

        shutdownAndAwaitForExecutor(executor);
        System.out.println(videoManager);

    }

    private static void shutdownAndAwaitForExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            executor.awaitTermination(DEFAULT_AWAIT_TIME_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Main was interrupted: " + e);
        }
        System.out.println("End!");
    }

    private static void doViewsInThreads(ExecutorService executor, VideoManagerInterface videoManager) {
        List<String> videos = new ArrayList<>();
        for (int i = 0; i < DEFAULT_VIDEOS; i++) {
            videos.add("Video #" + i);
        }

        for (int i = 0; i < DEFAULT_THREADS_FOR_ONE_VIDEO; i++) {
            for (String videoId : videos) {
                for (int time = 0; time < DEFAULT_TIMES_THREADS_FOR_ONE_VIDEO; time++) {
                    executor.execute(() -> videoManager.addView(videoId));
                }
            }
        }
    }
}
