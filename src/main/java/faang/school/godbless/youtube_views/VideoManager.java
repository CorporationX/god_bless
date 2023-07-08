package faang.school.godbless.youtube_views;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    public Map<String, Integer> viewsMap = new HashMap<>();
    public void addView(String videoID) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoID)) {
                int currentViews = viewsMap.get(videoID);
                viewsMap.put(videoID, ++currentViews);
                System.out.printf("Thread %s has watched the video %s and there is now %d viewing\n",
                        Thread.currentThread().getName(), videoID, currentViews);
            }
        }
    }
    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                return viewsMap.get(videoId);
            }
        }
        return -1;
    }
}
