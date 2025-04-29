package youtube.count;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

danbg12-BJS2-73727
    public synchronized void addViews(String videoId) {
        if (Objects.isNull(videoId) || videoId.isEmpty()) {
            log.warn("Illegal argument!");
            return;
        }
        viewsMap.compute(videoId, (k, v) -> v == null ? 1 : v + 1);
        log.info("Another view for video with id {}.", videoId);
    }

    public synchronized void getViewCount(String videoId) {
        if (Objects.isNull(videoId) || videoId.isEmpty()) {
            log.warn("Illegal argument!");
            return;
        } else if (!viewsMap.containsKey(videoId)) {
            log.warn("Illegal argument! Invalid videoId");
            return;
        }
        Integer views = viewsMap.get(videoId);
        log.info("Video with id: {} has {} views.", videoId, views);
 danbg12
    }
}
