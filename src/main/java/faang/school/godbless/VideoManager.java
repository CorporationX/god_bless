package faang.school.godbless;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId){
        if(viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public int getViewCount(String videoId){
        if (viewsMap.containsKey(videoId)) {
            return viewsMap.get(videoId);
        }
        throw new IllegalArgumentException("This video does not exist !");
    }
}
