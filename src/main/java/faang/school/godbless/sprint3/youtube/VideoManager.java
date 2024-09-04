package faang.school.godbless.sprint3.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        viewsMap.compute(videoId, (id, viewCount) -> viewCount == null ? 1 : viewCount + 1);
    }

    public int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }
}
