package faang.school.godbless.YouTubeViewsCounter;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<Integer, Integer> viewsMap = new HashMap<>();
    private final int NUM_VIDEOS = 50;

    public void addView(Integer videoID) {
        synchronized (viewsMap) {
            Integer videoViews = getViewCount(videoID);
            videoViews++;
            viewsMap.put(videoID, videoViews);
        }
    }

    public Integer getViewCount(Integer videoID) {
        synchronized (viewsMap) {
            return viewsMap.get(videoID);
        }
    }

    public void init() {
        for (int i = 0; i < NUM_VIDEOS; i++){
            viewsMap.put(i, 0);
        }
    }
}
