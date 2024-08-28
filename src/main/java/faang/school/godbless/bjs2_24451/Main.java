package faang.school.godbless.bjs2_24451;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int THREADS_PER_VIDEO = NUM_THREADS / NUM_VIDEOS;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videos = initVideos();

        videos.forEach(video -> {
            for (int i = 1; i <= THREADS_PER_VIDEO; i++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    log.info(video + " = " + videoManager.getViewCount(video) + " views");
                });
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        videoManager.printFinalResult();
    }

    private static List<String> initVideos() {
        var videos = new ArrayList<String>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videos.add("v" + i);
        }
        return videos;
    }
}
