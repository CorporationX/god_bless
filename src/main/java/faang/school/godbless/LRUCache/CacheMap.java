package faang.school.godbless.LRUCache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class CacheMap {
  private final int maxSize;
  @Getter
  private final Map<Integer, Data> map;

  public CacheMap(int maxSize) {
    this.maxSize = maxSize;
    this.map = new HashMap<>(maxSize);
  }

  public Data get(int id) {
    return map.get(id);
  }

  public void put(Data data) {
    if (map.size() == maxSize) {
      clearOldestData();
    }
    if (map.size() < maxSize) {
      map.put(data.getId(), data);
      return;
    }
    throw new RuntimeException("Ошибка добавления данных. Стэк переполнен");
  }

  private void clearOldestData() {
    Optional<Data> oldesDataOptional = map.values().stream()
        .min(Comparator.comparing(Data::getTimestamp));
    oldesDataOptional.ifPresentOrElse(
        (data -> map.remove(data.getId())),
        () -> log.error("Ошибка поиска самой старой записи"));
  }

  public void updateTimestamp(int id) {
    if (map.get(id) != null) {
      map.get(id).setTimestamp(System.currentTimeMillis());
    } else {
      log.error("Ошибка обновления времени последнего обращения. Объект: " + id + " отсутствует.");
    }
  }
}
