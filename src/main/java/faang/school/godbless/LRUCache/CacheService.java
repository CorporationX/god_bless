package faang.school.godbless.LRUCache;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class CacheService {
  private final Database database;
  private final CacheMap cacheMap;

  public CacheService(int dbSize, int cacheSize) {
    this.database = new Database(dbSize);
    this.cacheMap = new CacheMap(cacheSize);
  }

  public Data get(int id) {
    Data data = cacheMap.get(id);

    if (data == null) {
      data = database.getData().get(id);

      if (data == null) {
        throw new RuntimeException("Не удалось найти объект в базе данных с id: " + id);
      }
      cacheMap.put(data);
    }

    cacheMap.updateTimestamp(data.getId());
    return data;
  }

  public String getCacheState() {
    return cacheMap.getMap().toString();
  }
}
