package faang.school.godbless.bjs2_11906;

import java.util.List;
import java.util.Random;

public final class Utils {

  public static final int POOL_SIZE = 5;
  public static final long TIME_OUT = 10L;
  public static final String TRAVEL_ALL_WITCHERS_IS_OVER = " Путешествие всех ведтмаков закончкно";
  public static final int MAX_MONSTER_COUNT = 100;
  public static final int MIN_HABITAT_MONSTER = 1;
  public static final int MAX_HABITAT_MONSTER = 500;
  public static final int MAX_MONSTER_POWER = 100;
  public static final long TIME_PER_UNIT_OF_TRAVEL = 100;
  public static final long ROUTE_PLANNING_TIME = 500;
  public static final long TIME_TAKEN_RECEIVE_TASK = 800;
  public static final long FIGHT_TIME_PER_UNIT_FORCE = 100;

  private static final int NUMBER_DEGREE = 2;
  private static final int MAX_COORDINATE_NEGATIVE_POSITION = -1000;
  private static final int MAX_COORDINATE_POSITIVE_POSITION = 1000;
  private static final int ZERO_REFERENCE = 0;

  private Utils() {}

  /**
   *  Метод для нахождения расстояние между двумя точками
   * @param onePoint
   * @param twoPoint
   * @return округленное расстояние.
   */
  public static long getDistancesBetweenTwoPoints(Location onePoint, Location twoPoint) {
    return Math.round(Math.sqrt(Math.pow(onePoint.x() - twoPoint.x(), NUMBER_DEGREE) +
        Math.pow(onePoint.y() - twoPoint.y(), NUMBER_DEGREE)));
  }

  /**
   * Методя для генерации случайной локации.
   * @return новый объект локации с точкой в декартовой системе координат.
   */
  public static Location generateRandomLocation() {
    return generateRandomLocation(MAX_COORDINATE_NEGATIVE_POSITION,
        MAX_COORDINATE_POSITIVE_POSITION);
  }

  /**
   * Методя для генерации случайной локации в границах ограниченными 2мя позициями.
   * @param firstPosition
   * @param secondPosition
   * @return новый объект локации с точкой в декартовой системе координат.
   */
  public static Location generateRandomLocation(int firstPosition, int secondPosition) {
    final int coordinateX = getRandomCoordinate(getMinPosition(firstPosition), getMaxPosition(firstPosition));
    final int coordinateY = getRandomCoordinate(getMinPosition(secondPosition), getMaxPosition(secondPosition));
    return new Location(coordinateX, coordinateY);
  }

  /**
   * Методя для генерации случайной локации в границах ограниченными 4мя позициями.
   * @param leftPosition
   * @param topPosition
   * @param rightPosition
   * @param bottomPosition
   * @return новый объект локации с точкой в декартовой системе координат.
   */
  public static Location generateRandomHabitatLocation(int leftPosition,
      int topPosition,
      int rightPosition,
      int bottomPosition) {
    final int coordinateX = getRandomCoordinate(Math.min(leftPosition, rightPosition),
        Math.max(leftPosition, rightPosition));
    final int coordinateY = getRandomCoordinate(Math.min(topPosition, bottomPosition),
        Math.max(topPosition, bottomPosition));
    return new Location(coordinateX, coordinateY);
  }

  /**
   * Метод для получения наименьшего числа по сравнению с константой
   * @param number
   * @return минимальное значение из 2х
   */
  private static int getMinPosition(int number) {
    return Math.min(number, ZERO_REFERENCE);
  }

  /**
   * Метод для получения наибольшего числа по сравнению с константой
   * @param number
   * @return максимальное значение из 2х
   */
  private static int getMaxPosition(int number) {
    return Math.max(number, ZERO_REFERENCE);
  }

  /**
   * Метод создания слусайной точки.
   * @param firstPosition
   * @param secondPosition
   * @return точка в декартовой системе координат.
   */
  private static int getRandomCoordinate(int firstPosition, int secondPosition) {
    return new Random().nextInt(firstPosition, secondPosition);
  }

  /**
   * Методл для определения зоны обитания монстров в зависимости от основной локации.
   * @param habitatLocation основная локация (города)
   * @param maxHabitatDistance Зона мах. обитания монтров.
   * @return точка в декартовой системе координат в определенной зоне города.
   */
  public static Location getHabitatLocation(Location habitatLocation, int maxHabitatDistance) {
    final int leftPosition = incrementByN(habitatLocation.x(), maxHabitatDistance);
    final int topPosition = incrementByN(habitatLocation.y(), maxHabitatDistance);
    final int rightPosition = decrementByN(habitatLocation.x(), maxHabitatDistance);
    final int bottomPosition = decrementByN(habitatLocation.y(), maxHabitatDistance);
    return generateRandomHabitatLocation(leftPosition, topPosition, rightPosition, bottomPosition);
  }

  /**
   * Метод для увеличения координаты для вычисления зоны обитания монстров.
   * @param number координата
   * @param n значение зоны мах. обитания монтров.
   * @return новое значение координаты
   */
  private static int incrementByN(int number, int n) {
    return number > ZERO_REFERENCE ? number + n : number - n;
  }

  /**
   * Метод для уменьшения координаты для вычисления зоны обитания монстров.
   * @param number координата
   * @param n значение зоны мах. обитания монтров.
   * @return новое значение координаты
   */
  private static int decrementByN(int number, int n) {
    return number > ZERO_REFERENCE ? number - n : number + n;
  }

  /**
   * Метод для получания локации случайного города
   * @param cities список горордов
   * @return объект локации
   */
  public static Location getRandomCityLocation(List<City> cities) {
    return cities.get(new Random().nextInt(cities.size())).location();
  }

  /**
   * Метод для пролучения имения случайного монстра.
   * @param monsterNames список монстров
   * @return имя монстра
   */
  public static String getMonsterName(List<String> monsterNames) {
    return monsterNames.get(new Random().nextInt(monsterNames.size()));
  }

}
