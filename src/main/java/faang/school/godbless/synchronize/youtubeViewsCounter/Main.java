package faang.school.godbless.synchronize.youtubeViewsCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 500;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videos = new ArrayList<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videos.add("Video" + i);
        }

        VideoManager videoManager = new VideoManager();
        for (var video : videos ) {
            executorService.execute(() -> {
                videoManager.addView(video);
                getCountVideo(videoManager, video);
            });
            executorService.execute(() -> {
                videoManager.addView(video);
                getCountVideo(videoManager, video);
            });
            executorService.execute(() -> {
                videoManager.addView(video);
                getCountVideo(videoManager, video);
            });
            executorService.execute(() -> {
                videoManager.addView(video);
                getCountVideo(videoManager, video);
            });
            executorService.execute(() -> {
                videoManager.addView(video);
                getCountVideo(videoManager, video);
            });
        }

        executorService.shutdown();
        if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
            System.out.println("Done");
        }
    }

    private static void getCountVideo(VideoManager videoManager, String video) {
        System.out.println(video + " view count: " + videoManager.getViewCount(video));
    }
}
