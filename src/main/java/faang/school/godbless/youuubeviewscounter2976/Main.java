package faang.school.godbless.youuubeviewscounter2976;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 77;
    private static final int NUM_VIDEOS = 11;
    private static final int EXECUTIONS_QUANTITY = NUM_THREADS / NUM_VIDEOS;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService videoManagerExecutor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_THREADS; i++) {
            Video video = new Video("Video #" + i);
            for (int j = 0; j < EXECUTIONS_QUANTITY; j++) {
                videoManagerExecutor.execute(() -> {
                    String videoId = video.getVideoId();
                    videoManager.addView(videoId);
                    System.out.printf("%s - views: %d%n", videoId, videoManager.getViewCount(videoId));
                });
            }
        }
        videoManagerExecutor.shutdown();
        videoManagerExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        videoManager.getViewsMap()
                .forEach((videoId, views) -> System.out.printf("%s - Total views: %d%n", videoId, views));
    }
}
