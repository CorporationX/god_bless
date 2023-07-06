package faang.school.godbless.Multitrading2.ViewersCounterYouTube;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class VideoManager {
    private Map<Video, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(Video video) {
        viewsMap.putIfAbsent(video, 0);
        viewsMap.put(video, viewsMap.get(video) + 1);
    }

    public int getViewCount(Video video) {
        return viewsMap.getOrDefault(video, 0);
    }
}
