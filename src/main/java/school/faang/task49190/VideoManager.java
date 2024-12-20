package school.faang.task49190;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.compute(videoId, (id, count) -> {
            if (!viewsMap.containsKey(videoId)) {
                log.info("Было добавлено видео {}", videoId);
            }
            return viewsMap.getOrDefault(videoId, 0) + 1;
        });
    }

    public int getViewCount(String video) {
        if (video == null || video.isBlank()) {
            throw new IllegalArgumentException("video can`t be null or blank");
        }

        if (!viewsMap.containsKey(video)) {
            log.info("Такого видео не существует");
            return 0;
        }

        int count = viewsMap.get(video);

        log.info("Видео {} набрало {} просмотров", video, count);
        return count;
    }
}
