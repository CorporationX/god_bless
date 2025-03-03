package school.faang.BJS2_61628;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(@NonNull String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        log.info(ConstAndMessages.ADDED_VIEW_MESSAGE, videoId, getViewCount(videoId));
    }

    public synchronized int getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public void viewsStatistic() {
        for (Map.Entry<String, Integer> entry : viewsMap.entrySet()) {
            log.info(ConstAndMessages.VIDEO_VIEWS_COUNT_MESSAGE, entry.getKey(), entry.getValue());
        }
    }
}
