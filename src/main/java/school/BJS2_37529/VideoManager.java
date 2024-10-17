package school.BJS2_37529;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
            viewsMap.notify();
        }
    }

    public int getViewCount(String videoId) throws InterruptedException {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.wait();
            }
            System.out.printf("Количество просмотров видео %s = %d", videoId, viewsMap.get(videoId));
            System.out.println();
            return viewsMap.getOrDefault(videoId,0);
        }
    }
}