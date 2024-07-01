package faang.school.godbless.sprint2.youtube;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@Getter
@Slf4j
public class VideoManager {
  private Map<Video, Long> viewsMap;

  public synchronized void addView(String videoId) {
    Video video = getKeyById(videoId);
    Long count = viewsMap.get(video) + 1;
    log.info(count + " просмотров " + videoId);
    viewsMap.put(video, count);
  }

  public synchronized Long getViewCount(String videoId) {
    return viewsMap.get(getKeyById(videoId));
  }

  private Video getKeyById(String videoId) {
    return viewsMap.keySet()
        .stream()
        .filter((v) -> v.getId().equals(videoId))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Видео не найдено"));
  }
}
