package school.faang;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        //Integer quantityOfViews = viewsMap.get(videoId);
        //quantityOfViews ++;
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }


}
