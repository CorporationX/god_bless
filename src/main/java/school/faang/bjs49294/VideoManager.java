package school.faang.bjs49294;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public VideoManager(Map<String, Integer> viewsMap) {
        this.viewsMap = viewsMap;
    }

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.computeIfAbsent(videoId, (k) -> 0) + 1);
    }

    public synchronized Optional<Integer> viewCount(String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId));
    }
}
