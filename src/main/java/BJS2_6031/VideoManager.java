package BJS2_6031;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoID) {
        synchronized (viewsMap) {
            viewsMap.put(videoID, viewsMap.get(videoID) + 1);
        }
    }

    public void addVideo(String name) {
        viewsMap.put(name, 0);
    }

    public int getViewCount(String videoID) {
        synchronized (viewsMap) {
            return viewsMap.get(videoID);
        }
    }
}
