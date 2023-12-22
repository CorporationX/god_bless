package YouTube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<Integer, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(Integer id) {
        Integer currentViews = viewsMap.getOrDefault(id, 0);
        currentViews++;
        viewsMap.put(id, currentViews);
        System.out.println("К видео " + id + " добавлен просмотр");
    }

    public synchronized void getViewsCount(Integer id) {
        System.out.println("У видео " + id + " " + viewsMap.getOrDefault(id, 0) + " просмотров");
    }

}
