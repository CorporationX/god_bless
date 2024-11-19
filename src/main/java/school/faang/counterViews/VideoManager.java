package school.faang.counterViews;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class VideoManager {
    private Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(String videoId){
        getViewsMap().put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId){
        return viewsMap.get(videoId);
    }
}
