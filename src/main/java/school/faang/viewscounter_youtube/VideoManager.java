package school.faang.viewscounter_youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object viewsMapLock = new Object();

    public void addView(String video) {
        synchronized (viewsMapLock) {
            if (!viewsMap.containsKey(video)) {
                viewsMap.put(video, 0);
            }
            viewsMap.put(video, viewsMap.get(video) + 1);
        }
    }

    public int getViewCount(String video) {
        synchronized (viewsMapLock) {
            return viewsMap.get(video);
        }
    }

    public void addNewVideo(String video) {
        synchronized (viewsMapLock) {
            viewsMap.put(video, 0);
        }
    }

    public Map<String, Integer> getViewsMap() {
        synchronized (viewsMapLock) {
            return viewsMap;
        }
    }
}
