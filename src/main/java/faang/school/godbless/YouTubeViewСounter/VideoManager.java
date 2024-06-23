package faang.school.godbless.YouTubeViewСounter;

import lombok.Getter;

import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public void addView(String videoId) {
        synchronized (videoId.intern()) {
            viewsMap.put(videoId, getViewCount(videoId) + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (videoId.intern()) {
            return viewsMap.get(videoId);
        }
    }

    public VideoManager(Map<String, Integer> viewsMap) {
        this.viewsMap = viewsMap;
    }
}