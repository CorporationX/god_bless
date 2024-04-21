package faang.school.godbless.BJS2_5877;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addNewVideo(String videoId) {
        if (videoId != null) {
            viewsMap.putIfAbsent(videoId, 0);
        }
    }

    public synchronized void addView(String videoId) {
        if (!viewsMap.isEmpty()) {
            viewsMap.computeIfPresent(videoId, (k, v) -> v + 1);
        }
    }

    public synchronized void getViewCount(String videoId) {
        int viewCount = viewsMap.get(videoId);
        System.out.println(videoId + " = " + viewCount);
    }
}
