package faang.school.godbless.youTubeViews;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView (String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized Optional<Integer> getViewCount (String videoId) {
        return Optional.ofNullable(viewsMap.get(videoId));
    }
}
