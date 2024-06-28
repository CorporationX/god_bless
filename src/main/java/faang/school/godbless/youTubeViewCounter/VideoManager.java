package faang.school.godbless.youTubeViewCounter;

import java.util.HashMap;

public class VideoManager {

    private HashMap<Video, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(Video videoId) {
        if (viewsMap.containsKey(videoId)) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            System.out.println("Видео " + videoId.getVideoId() + "добавлено");
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public synchronized int getViewCount(Video videoId) {
        return viewsMap.get(videoId);
    }
}