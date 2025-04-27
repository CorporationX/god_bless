package school.faang.youtubecounter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public synchronized void addView(String videoId) {
        if (videoId == null || videoId.isBlank()) {
            log.warn("videoId не задан");
            return;
        }
        viewsMap.compute(videoId, (k, v) -> v == null ? 1 : v + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        if (videoId == null || videoId.isBlank()) {
            log.warn("videoId не задан");
            return 0;
        }
        return viewsMap.getOrDefault(videoId, 0);
    }
}