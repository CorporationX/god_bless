package school.faang.task_49303;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final Logger log = LoggerFactory.getLogger(VideoManager.class);
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addVideo(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        }
    }

    public void getViewCount(String videoId) {
        synchronized (viewsMap) {
            log.info("Get view count for video " + videoId);
            System.out.println(viewsMap.get(videoId));

        }
    }
}
