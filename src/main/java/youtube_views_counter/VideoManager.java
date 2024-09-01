package youtube_views_counter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addVideo(String videoId) {
        viewsMap.put(videoId, 0);
    }

    public void addView(String videoId) {
        viewsMap.computeIfPresent(videoId, (key, value) -> value + 1);
    }

    public int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

    public void printInfoAboutAllVideos() {
        viewsMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
