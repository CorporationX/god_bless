package school.faang.bjs2_90140;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {


    private final Map<String, Integer> views = new HashMap<>();

    public synchronized void addView(String videoId) {
        views.put(videoId, views.getOrDefault(videoId, 0) + 1);
    }

    public synchronized void getViewCount(String videoId) {
        log.info("Количество просомтров на видео {}: {}", videoId, views.getOrDefault(videoId, 0));
    }
}
