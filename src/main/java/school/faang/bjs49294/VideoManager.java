package school.faang.bjs49294;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized Optional<Integer> viewCount(String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId));
    }
}
