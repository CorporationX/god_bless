package faang.school.godbless.youtubecounter;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private Map<String, Integer> viewsMap = new HashMap<>();

    {
        for (int i = 0; i < 50; i++) {
            viewsMap.put("Video number " + i, 0);
        }
    }

    public void addView(String videoId) {
        synchronized (viewsMap) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
            System.out.println("One view is added to the " + videoId);
        }

    }

    public void getViewCount(String videoId) {
        synchronized (viewsMap) {
            System.out.println("The total number of views on the " + videoId + " is " + viewsMap.get(videoId));
        }
    }

}
