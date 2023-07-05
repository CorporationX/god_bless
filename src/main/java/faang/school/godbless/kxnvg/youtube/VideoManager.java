package faang.school.godbless.kxnvg.youtube;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    @Getter
    @Setter
    private Map<String, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public int getViewCount(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            return viewsMap.get(videoId);
        }
        throw new IllegalArgumentException("Такого видео нет");

    }
}
