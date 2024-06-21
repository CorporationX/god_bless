package faang.school.godbless.CountYouTube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Object lock = new Object();

    private Map<Video, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(Video videoId) throws InterruptedException {
//        synchronized (viewsMap) {
            if (viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            } else {
                viewsMap.put(videoId, 1);
            }
            viewsMap.wait();
//        }
    }

    public synchronized void getViewCount(Video videoId) {
//        synchronized (viewsMap) {
            System.out.println(videoId + " " +  viewsMap.get(videoId));
            viewsMap.notify();
//        }
    }
}
