package school.faang.synchronized__notify.bjs2_90019;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    @Getter
    private final Map<String, Integer> numberOfVideoViews = new HashMap<>();
    private final Object lock = new Object();

    public void addView(@NonNull String videoId) {
        synchronized (lock) {
            numberOfVideoViews.merge(videoId, 1, Integer::sum);
        }
    }

    public void addView(@NonNull Video video) {
        addView(video.videoId());
    }

    public void addView(int videoId) {
        addView(String.valueOf(videoId));
    }

    public Integer getViewCount(@NonNull String videoId) {
        synchronized (lock) {
            return numberOfVideoViews.getOrDefault(videoId, 0);
        }
    }

    public Integer getViewCount(int videoId) {
        return getViewCount(String.valueOf(videoId));
    }
}