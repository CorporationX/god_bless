package faang.school.godbless.synchronize.youtubeViewsCounter;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        System.out.println(videoId + " view added");
    }
    public synchronized int getViewCount(String videoId) {
        int result = 0;
        if (viewsMap.containsKey(videoId)) {
            result = viewsMap.get(videoId);
        }
        return result;
    }
}
