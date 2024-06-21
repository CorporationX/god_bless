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
        viewsMap.putIfAbsent(videoId, 0);

        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        System.out.println(videoId + " has one new view");
    }

    public synchronized int getViewCount(String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            log.warn("Could not find video by this videoId");
            return -1;
        }
        return viewsMap.get(videoId);
    }
}
