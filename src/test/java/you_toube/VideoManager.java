package you_toube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized Map<String, Integer> getViewsMap() {
        return new HashMap<>(viewsMap);
    }

    public synchronized void addView(String videoid) {
        viewsMap.put(videoid, viewsMap.getOrDefault(videoid, 50) + 1);
        ;
    }

    public  int getViewCount(String viewid) {
        return viewsMap.getOrDefault(viewid, 0);
    }
}
