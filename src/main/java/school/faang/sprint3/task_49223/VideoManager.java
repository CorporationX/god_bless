package school.faang.sprint3.task_49223;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>() {
    };

    public synchronized void addView(String videoId) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

    public void getAllVideo() {
        System.out.println("Все видео: ");
        viewsMap.entrySet()
                .forEach(System.out::println);
    }
}
