package faang.school.godbless.youtube;

import java.util.HashMap;

public class UnsyncedVideoManager implements VideoManagerI {
    private final HashMap<String, Integer> viewsMap = new HashMap<>();

    @Override
    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    @Override
    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}