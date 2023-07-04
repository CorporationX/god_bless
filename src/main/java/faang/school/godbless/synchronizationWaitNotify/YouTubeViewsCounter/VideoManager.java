package faang.school.godbless.synchronizationWaitNotify.YouTubeViewsCounter;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        System.out.printf("Поток: %s. Добавлен просмотр к видео: %s\n", Thread.currentThread().getName(), videoId);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
