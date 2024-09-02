package faang.school.godbless.multithreading.youtubecounter;

import java.util.Map;

public class VideoManager {

    private final Map<String, Integer> viewsMap;

    public VideoManager(Map<String, Integer> viewsMap) {
        this.viewsMap = viewsMap;
    }

    public synchronized void addView(String videoId) {
            if (!viewsMap.containsKey(videoId)) {
                throw new IllegalArgumentException("> no such video!");
            } else {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            }
    }

    public synchronized int getViewCount(String videoId) {
            System.out.println("> " + videoId +": " + viewsMap.get(videoId));

            return viewsMap.get(videoId);
    }

}
