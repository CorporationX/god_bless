package school.faang.viewscounter_youtube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final ConcurrentHashMap<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(String video) {
        if (!viewsMap.containsKey(video)) {
            viewsMap.put(video, 0);
        }
        viewsMap.put(video, viewsMap.get(video) + 1);
    }

    public int getViewCount(String video) {
        return viewsMap.get(video);
    }

    public void addNewVideo(String video) {
        viewsMap.put(video, 0);
    }

    public List<String> getVideos() {
        return viewsMap.keySet().stream().toList();
    }
}
