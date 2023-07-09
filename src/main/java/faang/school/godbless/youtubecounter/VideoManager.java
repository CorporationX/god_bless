package faang.school.godbless.youtubecounter;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            System.out.printf("Thread %s has watched the video %s and there is now %d viewing\n",
                    Thread.currentThread().getName(), videoId, viewsMap.get(videoId));
        }
    }

    public synchronized int getViewCount(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            return viewsMap.get(videoId);
        }
        return -1;
    }
}
