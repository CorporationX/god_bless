package school.faang.thirdStream.BJS2_37573;

import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
