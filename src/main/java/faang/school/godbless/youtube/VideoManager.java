package faang.school.godbless.youtube;

import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoManager {
    private Map<Video, Integer> viewsMap;

    public VideoManager() {
        viewsMap = new ConcurrentHashMap<>(64, 64, 1);
    }

    public void addVideo(Video video, int views) {
        viewsMap.put(video, views);
    }

    public int getViewCount(Video video) {
        return viewsMap.get(video);
    }

    public void addView(Video video) {
        viewsMap.put(video, viewsMap.get(video) + 1);
    }
}
