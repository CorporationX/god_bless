package faang.school.godbless.BJS2_24548;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.get(videoId);
        }
    }
}
