package faang.school.godbless.BJS2_24330;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<Integer, Integer> viewsMap = new HashMap<>();

    public void addVideo(int videoId) {
        viewsMap.putIfAbsent(videoId, 0);
    }

    public synchronized void addView(int videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(int videoId) {
        return viewsMap.get(videoId);
    }
}
