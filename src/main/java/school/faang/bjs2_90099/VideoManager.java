package school.faang.bjs2_90099;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.putIfAbsent(videoId, 0);
        viewsMap.put(videoId, getViewCount(videoId) + 1);
    }

    private int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
