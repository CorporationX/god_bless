package faang.school.godbless.youTube;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.putIfAbsent(videoId, 1);
        viewsMap.compute(videoId, (key, oldValue) -> oldValue + 1);
    }

    public synchronized int getViewCount(String videoId) {
        int totalViews = 0;
        for (Map.Entry<String, Integer> entry : viewsMap.entrySet()) {
            if (entry.getKey().contains(videoId)) {
                totalViews = entry.getValue();
            }
        }
        return totalViews;
    }
}
