package school.faang.youtube;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Getter
@Slf4j
public class VideoManager {
    private final ConcurrentMap<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public synchronized void addVideo(String video) {
        viewsMap.put(video, 0);
    }

    public synchronized void addView(String videoId) {
        int viewing = getViewCount(videoId) + 1;
        viewsMap.put(videoId, viewing);
        log.info("Видео: {}, Просмотров: {}", videoId, viewing);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }


}
