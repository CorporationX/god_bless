package school.faang.bjs249369.menager;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class VideoManager {
    private final Map<Integer, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(int id) {
        viewsMap.putIfAbsent(id, 0);
        viewsMap.put(id, viewsMap.get(id) + 1);
    }

    public synchronized int getViewCount(int id) {
        return viewsMap.getOrDefault(id, -1);
    }
}
