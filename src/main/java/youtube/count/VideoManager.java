package youtube.count;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public void addViews(String videoId) {
        synchronized (viewsMap) {
            if (Objects.isNull(videoId) || videoId.isEmpty()) {
                log.warn("Illegal argument!");
                return;
            }
            viewsMap.compute(videoId, (k, v) -> v == null ? 1 : v + 1);
            log.info("Another view for video with id {}.", videoId);
        }
    }

    public void getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (Objects.isNull(videoId) || videoId.isEmpty()) {
                log.warn("Illegal argument!");
                return;
            } else if (!viewsMap.containsKey(videoId)) {
                log.warn("Illegal argument! Invalid videoId");
                return;
            }
            Integer views = viewsMap.get(videoId);
            log.info("Video with id: {} has {} views.", videoId, views);
        }
    }
}
