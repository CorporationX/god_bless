package school.faang.score_youtube;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        if (!viewsMap.containsKey(videoId)) {
            System.out.println("Такого фильма нет");
            return 1;
        } else {
            return viewsMap.get(videoId) + 1;
        }
    }
}
