package faang.school.godbless.viewsCounterOnYoutube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
    private static final Map<String, Integer> views = new HashMap<>();

    public synchronized void addView(String videoId){
        if(views.get(videoId) != null){
            int counter = views.get(videoId);
            counter++;
            views.put(videoId,counter);
        }else {
            views.put(videoId, 1);
        }

    }

    public synchronized int getViewCount(String videoId){
        return views.get(videoId);
    }
}
