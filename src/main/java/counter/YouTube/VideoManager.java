package counter.YouTube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap  = new HashMap<>();

    public void addView(String videoId) {
        synchronized (this.viewsMap) {
            if (!this.viewsMap.containsKey(videoId)) {
                this.viewsMap.put(videoId, 0);
            }

            int viewVideo = this.viewsMap.get(videoId);
            this.viewsMap.put(videoId, ++viewVideo);
        }
    }

    public int getViewCount(String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            throw new RuntimeException("Видео не было найдено");
        }

        return this.viewsMap.get(videoId);
    }
}
