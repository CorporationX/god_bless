package youtube_1147;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.putIfAbsent(videoId, 0);
        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        System.out.println(" Добавлен просмотр " + videoId);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}