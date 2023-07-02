package faang.school.godbless.youtube_counter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<Integer, Integer > viewsMap = new HashMap<>();

    public synchronized void addView(int videoId){
        viewsMap.putIfAbsent(videoId, 0);
        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }

    public void getViewCount(int videoId){
        System.out.println(videoId + ": " + viewsMap.getOrDefault(videoId, 0));
    }
}
