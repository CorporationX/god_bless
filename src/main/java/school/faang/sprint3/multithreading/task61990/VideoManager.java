package school.faang.sprint3.multithreading.task61990;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager(Map<String, Integer> viewsMap) {
        this.viewsMap = new ConcurrentHashMap<>(viewsMap);
    }

    public synchronized void addView(String videoId) {
     viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized Integer getViewCount(String videoId) {
            return viewsMap.getOrDefault(videoId, 0);
    }
}
