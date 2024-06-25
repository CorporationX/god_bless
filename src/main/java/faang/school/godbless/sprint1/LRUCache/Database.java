package faang.school.godbless.sprint1.LRUCache;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * @author Evgenii Malkov
 */
public class Database {
  @Getter
  private final Map<Integer, Data> data = new HashMap<>();
  private final int size;

  public Database(int size) {
    this.size = size;
    fillDatabase();
  }

  private void fillDatabase() {
    for (int i = 0; i <= size; i++) {
      data.put(i, new Data(i, i + " value", System.currentTimeMillis()));
    }
  }
}
