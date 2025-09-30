package school.faang.bjs2_90140;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {


    private final Map<String, Integer> views = new HashMap<>();

    public synchronized void addView(String videoId) {
        views.merge(videoId,  1, Integer::sum);
    }

    public synchronized int getViewCount(String videoId) {
        return  views.getOrDefault(videoId, 0);
    }

    public void printViewCount(String videoId) {
        log.info("Количество просмотров на видео {}: {}", videoId, getViewCount(videoId));
    }
}
