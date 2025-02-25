package school.faang.youtubeviews;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    public final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public void addView(String videoId) {
        validateArgument(videoId);
        synchronized (lock) {
            int countViewsNow = viewsMap.getOrDefault(videoId, 0) + 1;
            viewsMap.put(videoId, countViewsNow);
        }
    }

    public int getViewCount(String videoId) {
        validateArgument(videoId);
        synchronized (lock) {
            return viewsMap.get(videoId);
        }
    }

    private void validateArgument(String argument) {
        if (argument == null || argument.isBlank()) {
            throw new IllegalArgumentException("Переданная строка не может быть пустой");
        }
    }
}
