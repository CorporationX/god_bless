package school.faang.sprint3.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private final Map<String, Integer> videoCount = new HashMap<>();

    public synchronized void addView(String videoId) {
        System.out.println(videoId + " addView IN");
        videoCount.put(videoId, videoCount.getOrDefault(videoId, 0) + 1);
        System.out.println(videoId + " added");
        System.out.println(videoId + " addView OUT");
    }

    public synchronized void getViewCount(String videoId) {
        System.out.println(videoId + " getViewCount IN");
        int a = videoCount.getOrDefault(videoId, 0);
        System.out.println(videoId + " watched " + a + " times");
        System.out.println(videoId + " getViewCount OUT");

    }

}
