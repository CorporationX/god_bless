package faang.school.godbless.youtube;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapVideoManager implements VideoManagerI {
    private final ConcurrentHashMap<String, Integer> viewsMap = new ConcurrentHashMap<>();

    @Override
    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    @Override
    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}