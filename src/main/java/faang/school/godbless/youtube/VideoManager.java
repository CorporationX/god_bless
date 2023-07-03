package faang.school.godbless.youtube;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {
  private Map<String, Integer> viewsMap = new HashMap<>();
  public synchronized void addView(String videoId) {
    int currentVideoViewCount = viewsMap.getOrDefault(videoId, 0);

    viewsMap.put(videoId, currentVideoViewCount + 1);
  }

  public synchronized int getViewCount(String videoId) {
    return viewsMap.get(videoId);
  }
}
