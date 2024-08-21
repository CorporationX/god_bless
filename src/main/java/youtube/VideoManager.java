package youtube;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class VideoManager {
    private final Object lock;
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(@NonNull String videoId) {
        synchronized (lock) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    public int getViewCount(@NonNull String videoId) {
        synchronized (lock) {
            if (viewsMap.containsKey(videoId)) {
                return viewsMap.get(videoId);
            } else {
                throw new IllegalArgumentException("Don't have video with this id");
            }
        }
    }
}
