package faang.school.godbless.sprint_3.multithreading.youtube_counter;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, 1);
                return;
            }
            int oldViews = viewsMap.get(videoId);
            viewsMap.put(videoId, oldViews + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                return 0;
            }
            return viewsMap.get(videoId);
        }
    }
}
