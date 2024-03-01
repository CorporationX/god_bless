package faang.school.godbless.BJS2_3250;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    @SneakyThrows
    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            } else {
                throw new IllegalArgumentException("videoId");
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                return viewsMap.get(videoId);
            } else {
                throw new IllegalArgumentException("videoId");
            }
        }
    }

    public void addVideo(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, 0);
            } else {
                throw new IllegalArgumentException("videoId");
            }
        }
    }

}