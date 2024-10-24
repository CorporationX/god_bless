package youTubeViewCounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String viewId) {
        synchronized (viewsMap) {
            viewsMap.putIfAbsent(viewId, 0);
            viewsMap.put(viewId, viewsMap.get(viewId) + 1);
        }
    }

    public int getViewCount(String viewId) {
        synchronized (viewsMap) {
            return viewsMap.get(viewId);
        }
    }
}
