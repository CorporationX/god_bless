package faang.school.godbless.sprint1.LRUCache;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
  private static final int DB_SIZE = 100;
  private static final int CACHE_SIZE = 3;

  public static void main(String[] args) {
    CacheService service = new CacheService(DB_SIZE, CACHE_SIZE);

    for (int i = 0; i < 10; i++) {
      System.out.println("Введите необходимый id объекта: ");
      Scanner scanner = new Scanner(System.in);
      int id = scanner.nextInt();

      log.info(String.format("Состояние объекта с id %s: %s", id, service.get(id)));
      log.info(String.format("Состояние CacheMap: %s", service.getCacheState()));
      log.info("-------------------------------------------------------------");
      System.out.println();
    }
  }
}
