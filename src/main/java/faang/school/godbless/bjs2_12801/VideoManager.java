package faang.school.godbless.bjs2_12801;

import java.util.HashMap;
import java.util.Map;

public class VideoManager {

  private static final String SEPARATOR = "_id_";
  private static final String VIEWED_VIDEOS = " %s %s просмотренно %d раз";

  private Map<String, Integer> viewsMap = new HashMap<>();

  public synchronized void addView(Video video) {
    final String videoName = getName(video);
    viewsMap.compute(videoName, (key, value) -> value == null ? 1 : ++value);
  }

  public synchronized void showViewCount(Video video) {
    final String name = getName(video);
    if (viewsMap.containsKey(name)) {
      final int currentVideoName = viewsMap.get(name);
      System.out.println(
          String.format(VIEWED_VIDEOS, Thread.currentThread().getName(), name, currentVideoName));
    }
  }

  private String getName(Video video) {
    return video.name() + SEPARATOR + video.id();
  }

}
