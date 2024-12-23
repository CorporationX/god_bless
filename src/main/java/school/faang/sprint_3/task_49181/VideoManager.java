package school.faang.sprint_3.task_49181;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> v == null ? 1 : v + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
