package school.faang.sprint3.task_49256;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor
public class VideoManager {

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(@NonNull String videoId) {
        viewsMap.compute(videoId, (id, viewCount) -> viewCount == null ? 1 : viewCount++);
    }

    public Integer getViewCount(@NonNull String videoId) {
        return viewsMap.computeIfAbsent(videoId, (id) -> 0);
    }

    public void addVideo(@NonNull String videoId) {
        viewsMap.put(videoId, 0);
    }

}
