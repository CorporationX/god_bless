package school.faang.bjs249480;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VideoManager {
    private final Map<UUID, View> viewsMap = new HashMap<>();

    public void addView(UUID videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, new View());
            }
        }

        View view = viewsMap.get(videoId);
        synchronized (view) {
            view.increaseViews();
        }
    }

    public Integer getViewCount(UUID videoId) {
        View view = viewsMap.get(videoId);
        synchronized (view) {
            return view.getViews();
        }
    }
}
