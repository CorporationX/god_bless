package school.faang.task_49258;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class VideoManager {
    private final ConcurrentHashMap<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }

    @Synchronized
    public void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        log.info("Добавили просмотр видео {}", videoId);
    }

    @Synchronized
    public Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public Integer getAllVideoCount() {
        return viewsMap.size();
    }

    public Integer getAllViewCount() {
        return viewsMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}
