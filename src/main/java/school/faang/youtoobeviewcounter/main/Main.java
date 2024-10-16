package school.faang.youtoobeviewcounter.main;

import school.faang.youtoobeviewcounter.maincode.VideoManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 100;
    private static final int VIDEO_COUNT = 10;
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < VIDEO_COUNT; i++) {
            String videoId = "video_" + i;

            for (int j = 0; j < THREAD_COUNT / VIDEO_COUNT; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Видео " + videoId
                            + "просмотров " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
