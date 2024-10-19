package school.faang.views.counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        System.out.println(Thread.currentThread().getName() + " добавление просмотров к видео " + videoId);
        viewsMap.merge(videoId, 1, Integer::sum);
        System.out.println(viewsMap.get(videoId));
    }

    public synchronized int getView(String videoId) {
        System.out.println(Thread.currentThread().getName() + " получение просмотров видео " + videoId);
        System.out.println(viewsMap.get(videoId));
        return viewsMap.get(videoId);
    }

    public void printReport() {
        viewsMap.forEach((key, value) -> System.out.println(key + ": " + value));
        int totalViewsCount = viewsMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Общее кол-во просмотров " + totalViewsCount);
    }
}
