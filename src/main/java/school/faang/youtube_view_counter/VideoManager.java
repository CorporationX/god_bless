package school.faang.youtube_view_counter;

import lombok.Getter;

import java.util.Map;

@Getter
public class VideoManager {

    private Map<String, Integer> viewsMap;

    public VideoManager(Map<String, Integer> viewsMap) {
        this.viewsMap = viewsMap;
    }

    private Object lock = new Object();

    public void addView(String videoId) {
        synchronized (lock) {
            Integer views = viewsMap.get(videoId) + 1;
            viewsMap.put(videoId, views);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            Integer views = viewsMap.get(videoId);
            return views;
        }
    }
}
