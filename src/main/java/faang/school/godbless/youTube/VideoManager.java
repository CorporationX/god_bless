package faang.school.godbless.youTube;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class VideoManager {
    private Map<Video, Integer> viewsMap;


    public synchronized void addView(String videoId) {
        for (Map.Entry<Video, Integer> entry : viewsMap.entrySet()) {
            if (entry.getKey().getId().contains(videoId)) {
                int value = entry.getValue();
                entry.setValue(value + 1);
            }
        }
    }

    public synchronized int getViewCount(String videoId) {
        int totalViews = 0;
        for (Map.Entry<Video, Integer> entry : viewsMap.entrySet()) {
            if (entry.getKey().getId().contains(videoId)) {
                totalViews = entry.getValue();
            }
        }
        return totalViews;
    }
}
