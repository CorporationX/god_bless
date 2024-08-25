package faang.school.godbless.BJS2_24407;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class VideoManager {

    private final Map<String, Integer> views;

    public synchronized void addView(String videoId) {
        views.put(videoId, views.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return views.getOrDefault(videoId, 0);
    }
}
