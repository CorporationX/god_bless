package faang.school.godbless.BJS2_24407;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> views = new HashMap<>();

    public void addVideo(String video) {
        views.putIfAbsent(video, 0);
    }

    public synchronized void addView(String videoId) {
        views.put(videoId, views.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return views.getOrDefault(videoId, 0);
    }
}
