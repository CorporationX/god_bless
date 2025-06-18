package school.faang.module1.bjs2_81700;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> {
            int newCount = (v == null) ? 1 : v + 1;
            log.info("Добавлен просмотр к {}: теперь {}", videoId, newCount);
            return newCount;
        });
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}