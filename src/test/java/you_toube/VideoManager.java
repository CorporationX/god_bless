package you_toube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public Map<String, Integer> getViewsMap() {
        return viewsMap;
    }

    public synchronized void addView(String videoid) {
        viewsMap.put(videoid, viewsMap.getOrDefault(videoid, 50) + 1);
        ;
    }

    public synchronized int getViewCount(String viewid) {
        return viewsMap.getOrDefault(viewid, 0);
    }
}
