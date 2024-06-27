package faang.school.godbless.sprint_3.multithreading_synchronization.task_5_youtube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) {
        Map<String, Integer> idViewMap = createMap();
        VideoManager manager = new VideoManager(idViewMap);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            Thread t = new Thread(() -> {
                for (var e : idViewMap.entrySet()) {
                    manager.addView(e.getKey());
                    manager.getViewCount(e.getKey());
                }
            });
            executor.execute(t);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String videoId = "video_10";
        System.out.printf("Видео: %s\nКоличество просмотров: %d\n", videoId, idViewMap.get(videoId));

    }

    private static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            map.put("video_" + i, 0);
        }
        return map;
    }
}
