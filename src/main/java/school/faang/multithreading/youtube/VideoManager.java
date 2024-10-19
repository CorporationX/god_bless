package school.faang.multithreading.youtube;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class VideoManager {

  private final Map<String, Integer> views = new HashMap<>();

  public synchronized void addView(String videoId) {
    int count = getViewCount(videoId);
    views.put(videoId, ++count);
    System.out.println(videoId + " NEW view by " + Thread.currentThread().getName());
    System.out.println("actual views: " + getViewCount(videoId));
  }

  public synchronized int getViewCount(String videoId) {
    return views.computeIfAbsent(videoId, views -> 0);
  }

}
