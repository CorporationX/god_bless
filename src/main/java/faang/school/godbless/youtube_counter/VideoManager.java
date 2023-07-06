package faang.school.godbless.youtube_counter;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {

    private Map<Integer, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(Integer video) {
        int viewsCountIncrement = getViewCount(video) + 1;
        viewsMap.replace(video, viewsCountIncrement);
    }

    public int getViewCount(Integer video) {
        return viewsMap.get(video);
    }
}
