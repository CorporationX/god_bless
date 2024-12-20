package school.faang.task_49123;

import lombok.NonNull;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(@NonNull String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(@NonNull String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            throw new NoSuchElementException("Video for this id" + videoId + "not found");
        }
        return viewsMap.get(videoId);
    }
}
