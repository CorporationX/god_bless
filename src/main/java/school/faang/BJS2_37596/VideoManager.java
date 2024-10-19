package school.faang.BJS2_37596;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addVie(String videoId) {
        Integer vies = viewsMap.get(videoId);
        if (vies == null){
            vies = 0;
        }
        vies++;
        viewsMap.put(videoId, vies);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
