package faang.school.godbless.youtube_views_counter;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@AllArgsConstructor
public class VideosManager {
    private Map<String, Integer> viewsMap;

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.compute(videoId, (a, b) -> b + 1);
            notifyAll();
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                try {
                    viewsMap.wait(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return viewsMap.get(videoId);
    }
}
