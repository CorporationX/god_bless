package faang.school.godbless.sprint_3.multithreading.youtube_counter;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 1) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
