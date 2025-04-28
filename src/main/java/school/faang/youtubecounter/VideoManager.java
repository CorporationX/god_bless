package school.faang.youtubecounter;

import lombok.NonNull;
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
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized Integer getViewCount(@NonNull String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}