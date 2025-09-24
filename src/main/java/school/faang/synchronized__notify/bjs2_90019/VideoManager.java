package school.faang.synchronized__notify.bjs2_90019;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Getter
@Slf4j
public class VideoManager {
    private final Map<String, Integer> numberOfVideoViews = new HashMap<>();

    public synchronized void addView(@NonNull String videoId) {
        numberOfVideoViews.merge(videoId, 1, Integer::sum);
    }

    public void addView(@NonNull Video video) {
        addView(video.videoId());
    }

    public void addView(int videoId) {
        addView(String.valueOf(videoId));
    }

    public synchronized Integer getViewCount(@NonNull String videoId) {
        return numberOfVideoViews.getOrDefault(videoId, 0);
    }

    public Integer getViewCount(int videoId) {
        return getViewCount(String.valueOf(videoId));
    }
}