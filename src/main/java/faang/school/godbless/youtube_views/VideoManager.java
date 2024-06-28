package faang.school.godbless.youtube_views;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
        log.info(videoId + " has one new view");
    }

    public synchronized int getViewCount(String videoId) {
        int views = viewsMap.getOrDefault(videoId, 0);
        if (views == 0) {
            log.warn("Could not video by videoId: " + videoId);
        }
        return views;
    }
}
