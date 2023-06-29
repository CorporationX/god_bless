package faang.school.godbless.counterOfViews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private volatile Map<String, Integer> viewsMap = new HashMap<>();
    final Object lockForMap = new Object();

    public synchronized void addView(String videoId){
        if(!viewsMap.containsKey(videoId)){
            viewsMap.put(videoId, 0);
        }
        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }
    public int getViewCount(String videoId){
        return viewsMap.getOrDefault(videoId, 0);
    }
}
