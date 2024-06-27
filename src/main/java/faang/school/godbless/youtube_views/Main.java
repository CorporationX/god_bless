package faang.school.godbless.youtube_views;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;
    private static final int TIME_LIMIT = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<String> videoIdList = getVideoIdList();

        videoIdList.forEach((videoId) -> {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    log.info(videoId + " has total views: " + videoManager.getViewCount(videoId));
                });
            }
        });

        executorService.shutdown();

        try {
            boolean isFinishedOnTime = executorService.awaitTermination(TIME_LIMIT, TimeUnit.SECONDS);
            if (isFinishedOnTime) {
                log.info("The task was finished on time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Executor service was interrupted during execution: " + e.getMessage());
        }

        System.out.println(videoManager.getViewsMap());
    }

    public static List<String> getVideoIdList() {
        List<String> videoIdList = new ArrayList<>();

        IntStream.range(1, NUM_VIDEOS + 1).mapToObj(String::valueOf).forEach(videoIdList::add);

        return videoIdList;
    }
}
