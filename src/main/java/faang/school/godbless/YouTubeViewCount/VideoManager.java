package faang.school.godbless.YouTubeViewCount;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<Video, Integer> videosViews = new HashMap<Video, Integer>();


    public synchronized void addViewToVideo(Video video) {
        videosViews.putIfAbsent(video, 0);
        videosViews.put(video, videosViews.get(video) + 1);
    }

    public synchronized int getViewCount(Video video) {
        return videosViews.get(video);
    }
}
