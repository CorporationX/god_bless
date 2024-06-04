package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
  private static final Map<String, House> houseMap = new HashMap<>();

  /**
   * Метод для добавления нового дома.
   * @param houseName Наименование дома.
   * @param house Объект дома.
   */
  private static void addHouse(String houseName, House house) {
    houseMap.put(houseName, house);
  }

  /**
   * Метод для удаления дома.
   * @param houseName Наименование дома.
   */
  private static void remoteHouse(String houseName) {
      houseMap.remove(houseName);
  }

  /**
   * Метод для поиска дома и вывод информации о гербе дома по его названию.
   * @param houseName Наименование дома.
   */
  private static void findHouse(String houseName) {
    House house = houseMap.get(houseName);
    var result = Optional.ofNullable(house)
        .map(House::getSigil)
        .orElse("");
    System.out.println(result);
  }

  /**
   * Метод для вывода списка всех домов и их гербов.
   */
  private static void showAllHouse() {
    houseMap.forEach((key, value) -> System.out.println(key + " " + value.getSigil()));
  }


  public static void main(String[] args) {
    House houseStark = new House("Старк", "stark");
    House houseLanister = new House("Ланнистер", "lanister");
    House houseBarteon = new House("Баратеон", "barteon");
    House houseTargarien = new House("Таргариен", "targarien");

    addHouse(houseStark.getName(), houseStark);
    addHouse(houseLanister.getName(), houseLanister);
    addHouse(houseBarteon.getName(), houseBarteon);
    addHouse(houseTargarien.getName(), houseTargarien);

    remoteHouse(houseBarteon.getName());

    findHouse(houseTargarien.getName());

    showAllHouse();
  }

}
