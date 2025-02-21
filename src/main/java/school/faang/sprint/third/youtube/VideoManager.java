package school.faang.sprint.third.youtube;

import lombok.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = Collections.synchronizedMap(new HashMap<>());

    public void addView(@NonNull String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public int getViewCount(@NonNull String videoId) {
        return viewsMap.get(videoId);
    }
}
