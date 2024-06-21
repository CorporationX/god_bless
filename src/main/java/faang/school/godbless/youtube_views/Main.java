package faang.school.godbless.youtube_views;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

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
                new Thread(() -> {
                    videoManager.addView(videoId);

                    System.out.println(videoId + " has total views: " + videoManager.getViewCount(videoId));
                }).start();
            }
        });

        executorService.shutdown();

        try {
            boolean result = executorService.awaitTermination(TIME_LIMIT, TimeUnit.SECONDS);
            if (result) {
                System.out.println("All task were completed on time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(videoManager.getViewsMap());
    }

    public static List<String> getVideoIdList() {
        List<String> videoIdList = new ArrayList<>();

        IntStream.range(1, NUM_VIDEOS + 1).mapToObj(String::valueOf).forEach(videoIdList::add);

        return videoIdList;
    }
}
