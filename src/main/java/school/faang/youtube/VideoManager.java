package school.faang.youtube;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Random;

@Data
@AllArgsConstructor
public class VideoManager {
    private Map<String, Integer> views;

    public synchronized void addView(String videoId) {
        Random random = new Random();
        if (views.containsKey(videoId)) {
            views.put(videoId, views.get(videoId) + random.nextInt(10, 5000000));
        } else {
            views.put(videoId, 1);
        }
    }

    public synchronized void getViewCount(String videoId) {
        if (views.containsKey(videoId)) {
            System.out.println("The video " + videoId + " has " + views.get(videoId) + " views");
        } else {
            System.out.println("No video found for this request");
        }
    }
}
