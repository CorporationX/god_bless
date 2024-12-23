package school.faang.sprint3.task_49223;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private static final Map<String, Integer> viewsMap = new ConcurrentHashMap<>() {
    };

    public static void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }

    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.get(videoId);
        }
    }

    public void getAllVideo() {
        System.out.println("Все видео: ");
        viewsMap.entrySet().stream()
                .forEach(System.out::println);
    }
}
