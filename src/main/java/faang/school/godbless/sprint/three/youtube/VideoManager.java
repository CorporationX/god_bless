package faang.school.godbless.sprint.three.youtube;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lockViews = new Object();

    public void addView(String videoId) {
        synchronized (lockViews) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, 0);
            }
            int currentViews = getViewCount(videoId);
            currentViews++;
            viewsMap.put(videoId, currentViews);
        }
    }

    private int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

}
