package school.faang.sprint3.task_49223;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>() {
    };

    public void addView(String videoId) {
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
        viewsMap.entrySet()
                .forEach(System.out::println);
    }
}
