package school.faang.BJS2_37620;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        videoManager.initializeVideos(NUM_VIDEOS);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        int viewsPerVideo = NUM_THREADS / NUM_VIDEOS;

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < viewsPerVideo; j++) {
                executorService.submit(new ViewTask(videoManager, videoId));
            }
        }

        executorService.shutdown();
        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            out.println("Не все задачи завершены.");
        }

        out.println(" тоговые просмотры:");
        videoManager.getAllViews().forEach((videoId, count) ->
            out.println(videoId + ": " + count));
    }
}
