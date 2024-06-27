package faang.school.godbless.youTubeViewCounter;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<Integer, Integer> viewsMap = Collections.synchronizedMap(new HashMap<>());

    public synchronized void addView(int videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            throw new IllegalArgumentException("Video ID " + videoId + " does not exist");
        }
    }

    public synchronized int getViewCount(int videoId) {
        if (viewsMap.containsKey(videoId)) {
            return viewsMap.get(videoId);
        }
        throw new IllegalArgumentException("Video ID " + videoId + " does not exist");
    }
}
