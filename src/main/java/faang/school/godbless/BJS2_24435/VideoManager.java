package faang.school.godbless.BJS2_24435;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(String videoId) {
        if (videoId == null) {
            throw new IllegalArgumentException("Video id cannot be null");
        }
        return viewsMap.get(videoId);
    }
}
