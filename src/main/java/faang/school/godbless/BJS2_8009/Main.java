package faang.school.godbless.BJS2_8009;

import java.util.HashMap;
import java.util.Map;

public class Main {
  static Map<String, House> houses = new HashMap<>();
  public static void main(String[] args) {
    houses.put("Таргариен", new House("Таргариен", "Дракон"));
    houses.put("Старк", new House("Старк", "Волк"));
    houses.put("Ланнистер", new House("Ланнистер", "Лев"));
    System.out.println(houses);
    addHouse(new House("Баратеон", "Олень"));
    System.out.println(houses);
    deleteHouse("Старк");
    System.out.println(houses);
    System.out.println(getSigilFromName("Таргариен"));
    getAllHouses();
  }

  public static void addHouse(House house) {
    houses.put(house.getName(), house);
  }

  public static void deleteHouse(String name) {
    houses.remove(name);
  }

  public static String getSigilFromName(String name) {
    return houses.get(name).getSigil();
  }

  public static void getAllHouses() {
    for (Map.Entry<String, House> entry : houses.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue().getSigil());
    }
  }
}
