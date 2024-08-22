package faang.school.godbless.BJS2_24339;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        String currentThread = Thread.currentThread().getName();
        synchronized (viewsMap) {
            System.out.println(currentThread + ": Добавление просмотра к видео № " + videoId);
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
                System.out.printf("%s: Просмотр добавлен к видео № %s. Текущее значение счетчика для видео № %s = %d%n",
                        currentThread, videoId, videoId, viewsMap.get(videoId));
            }
            else {
                System.out.printf("%s: В мапе еще нет информации по видео № %s. Додавляем первый просмотр%n",
                        currentThread, videoId);
                viewsMap.put(videoId, 1);
                System.out.printf("%s: Добавили первый просмотр к видео № %s%n", currentThread, videoId);
            }
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            return viewsMap.getOrDefault(videoId, 0);
        }
    }

    public void printViewMap() {
        viewsMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
