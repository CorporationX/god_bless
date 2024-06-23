package faang.school.godbless.YouTubeViewСounter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class Main {
    private static final Random random = new Random();
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 4;
    private static final int NUM_ALL_VIEWERS = 10000;
    private static final ExecutorService execute = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager(getViewsMap());
        allViewersDoRandomAction(videoManager);
        execute.shutdown();
        try {
            execute.awaitTermination(2, SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("execute.awaitTermination in main interrupted while waiting" + e);
        }
        printAllVideoViews(videoManager);
    }

    public static Map<String, Integer> getViewsMap() {
        Map<String, Integer> viewsMap = new HashMap<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            int videoId = i * 13;
            viewsMap.put(Integer.toString(videoId), 0);
        }
        return viewsMap;
    }

    public static void allViewersDoRandomAction(VideoManager videoManager) {
        List<String> allVideoId = videoManager.getViewsMap().keySet().stream().toList();
        for (int i = 0; i < NUM_ALL_VIEWERS; i++) {
            execute.submit(() -> {
                int randomIndex = random.nextInt(0, NUM_VIDEOS);
                videoManager.addView(allVideoId.get(randomIndex));
            });
        }
    }

    public static void printAllVideoViews(VideoManager videoManager) {
        for (String videoId : videoManager.getViewsMap().keySet()) {
            log.info("ID " + videoId + " | views " + videoManager.getViewCount(videoId));
        }
    }
}
