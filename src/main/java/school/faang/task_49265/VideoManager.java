package school.faang.task_49265;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String video) {
        viewsMap.merge(video, 1, Integer::sum);
    }

    public int getViewCount(String video) {
        return viewsMap.get(video);
    }

    public void addVideos(List<String> videos) {
        videos.forEach((video) -> viewsMap.put(video, 0));
    }
}
