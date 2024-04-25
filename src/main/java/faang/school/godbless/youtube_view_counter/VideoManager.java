package faang.school.godbless.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            throw new IllegalArgumentException("Аргумент videId не может быть null или пустым");
        }
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        if (videoId == null || videoId.isEmpty()) {
            throw new IllegalArgumentException("Аргумент videId не может быть null или пустым");
        }
        return viewsMap.get(videoId);
    }
}
