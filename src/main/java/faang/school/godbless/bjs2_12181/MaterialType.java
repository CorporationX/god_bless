package faang.school.godbless.bjs2_12181;

import java.util.Map;

public final class MaterialType {
  private static final long DEFAULT_TIME = 10000L;
  private static final Map<String, Long> typeMap =
      Map.of("солома", 1000L, "палки", 3000L, "кирпичи", 5000L);

  private MaterialType() {}

  /**
   * Метод для поиска времени на строительсво в зависимости от типа материала.
   * @param type тип материала
   * @return время стоительства.
   */
  public static long findByType(String type) {
    return typeMap.getOrDefault(type.toLowerCase(), DEFAULT_TIME);
  }
}
