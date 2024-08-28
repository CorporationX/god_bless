package faang.school.godbless.bjs224458;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> v + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

    public void addVideo(String videoId) {
        this.viewsMap.put(videoId, 0);
    }
}
