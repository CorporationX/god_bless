package faang.school.godbless.BJS2_24505;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public void addVideo(String videoId) {
        viewsMap.put(videoId, 0);
    }

    public int getVideoCount() {
        return viewsMap.size();
    }

    public void addView(String videoId) {
        synchronized (lock) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (lock) {
            if (viewsMap.containsKey(videoId)) {
                int countVideo = viewsMap.get(videoId);
                if (countVideo != 0) {
                    System.out.println(videoId + ": " + countVideo);
                }
                return viewsMap.get(videoId);
            }
            return 0;
        }
    }
}
