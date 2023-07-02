package sprint4.youtube;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                int currentViews = viewsMap.get(videoId);
                viewsMap.put(videoId, ++currentViews);
                System.out.printf("Thread %s has watched the video %s and there is now %d viewing\n",
                        Thread.currentThread().getName(), videoId, currentViews);
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                throw new IllegalArgumentException("Sorry, there is no such video :(");
            }
            return viewsMap.get(videoId);
        }
    }
}
