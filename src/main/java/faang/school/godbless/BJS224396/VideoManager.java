package faang.school.godbless.BJS224396;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Getter
public class VideoManager {
    private Map<Long, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addView(long videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(long videoId) {
        return viewsMap.get(videoId);
    }
}
