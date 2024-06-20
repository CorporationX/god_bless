package faang.school.godbless.synchronization.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

    private Map<String, Integer> viewCount = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewCount.merge(videoId, 1, Integer::sum);
        System.out.println(videoId + " added a view");
    }

    public synchronized int getViewCount(String videoId) {
        Integer countView = viewCount.getOrDefault(videoId, 0);
        System.out.println("View count for " + videoId + " is " + countView);
        return countView;
    }
}
