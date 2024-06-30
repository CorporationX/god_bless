package faang.school.godbless.youtube;

import java.util.HashMap;

public class VideoManager implements VideoManagerI {

    private final HashMap<String, Integer> viewsMap = new HashMap<>();

    @Override
    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.merge(videoId, 1, Integer::sum);
        }
    }

    @Override
    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }
}
