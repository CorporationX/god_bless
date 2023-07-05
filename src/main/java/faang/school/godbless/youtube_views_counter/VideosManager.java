package faang.school.godbless.youtube_views_counter;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@AllArgsConstructor
public class VideosManager {
    private Map<String, Integer> viewsMap;

    public  synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (a, b) -> b + 1);
        notifyAll();
    }

    public synchronized int getViewCount(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            try {
                wait(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return viewsMap.get(videoId);
    }
}
