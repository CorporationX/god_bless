package faang.school.godbless.viewscounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private Map<Long, Long> viewsMap = new HashMap<>();

    public synchronized void addView(Long videoId) {
        viewsMap.putIfAbsent(videoId, 0L);
        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }

    public synchronized Long getViewCount(Long videoId) {
        return viewsMap.getOrDefault(videoId, 0L);
    }

    public void addVideo(Long videoId) {
        viewsMap.putIfAbsent(videoId, 0L);
    }
}
