package faang.school.godbless.sprint3.youtubeCounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new HashMap<>();
    private final Object lock = new Object();

    public VideoManager() {
    }

    public void addView(String id) {
        System.out.println("before adding sync view: " + id);
        synchronized (lock) {
            boolean existsViewById = viewsMap.containsKey(id);
            System.out.println("map before adding count: " + viewsMap);

            if (existsViewById) {
                viewsMap.computeIfPresent(id, (key, value) -> value + 1);
            } else {
                viewsMap.putIfAbsent(id, 1);
            }

            System.out.println("map after adding count: " + viewsMap);
        }
    }

    public int getViewCount(String id) {
        System.out.println("before getting sync count by: " + id);
        synchronized (lock) {
            System.out.println("view count by id " + id + " : " + viewsMap.get(id));
            return viewsMap.get(id);
        }
    }
}
