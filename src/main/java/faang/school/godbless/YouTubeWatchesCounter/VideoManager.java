package faang.school.godbless.YouTubeWatchesCounter;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

    public void addVideo(String videoId) {
        viewsMap.put(videoId, 0);
    }
}
