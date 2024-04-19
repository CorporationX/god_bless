package faang.school.godbless.youtube;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId){
        synchronized (viewsMap) {
            viewsMap.compute(videoId, (key, value) -> value == null ? 1 : value+1);
        }
    }

    public int getViewCount(String videoId){
        synchronized (viewsMap) {
            return viewsMap.get(videoId);
        }
    }
}
