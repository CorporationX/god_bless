package faang.school.godbless.sprint3.youtubeCounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public VideoManager() {
    }

    public synchronized void addView(String id) {
        System.out.println("before adding sync view: " + id);
        System.out.println("map before adding count: " + viewsMap);

        Integer value = viewsMap.getOrDefault(id, 0);
        viewsMap.put(id, value + 1);

        System.out.println("map after adding count: " + viewsMap);
    }

    public synchronized int getViewCount(String id) {
        System.out.println("before getting sync count by: " + id);
        System.out.println("view count by id " + id + " : " + viewsMap.get(id));
        return viewsMap.getOrDefault(id, 0);
    }
}
