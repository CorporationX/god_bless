package faang.school.godbless.YoutubeWatches;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId){
        int currentViews = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, currentViews+1);
    }

    public synchronized int getViewCount(String videoId){
        return viewsMap.getOrDefault(videoId, 0);
    }

}
