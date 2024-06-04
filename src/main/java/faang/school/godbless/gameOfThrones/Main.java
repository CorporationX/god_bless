package faang.school.godbless.gameOfThrones;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {
  private static final Map<String, House> vesterosHouses = new HashMap<>();
  public static void main(String[] args) {
    vesterosHouses.put("Старк", new House("Старк", "Зима близко"));
    vesterosHouses.put("Ланнистеры", new House("Ланнистеры", "Hear me Roar"));
    vesterosHouses.put("Баратеон", new House("Баратеон", "Нам это дано"));

    String voronins = "Воронины";
    HouseService.addHouse(voronins, new House(voronins, "Люся"));
    HouseService.removeHouse("Баратеон");
    log.info(String.format("Sigil info about house: %s | %s", voronins, HouseService.getSigilInfoByHouseName(voronins)));
    HouseService.printHousesInfo();
  }

  public static class HouseService {
    public static void addHouse(String houseName, House house) {
      vesterosHouses.put(houseName, house);
      log.info(String.format("Added house: %s | %s", houseName, vesterosHouses));
    }

    public static void removeHouse(String houseName) {
      vesterosHouses.remove(houseName);
      log.info(String.format("Removed house: %s | %s", houseName, vesterosHouses));
    }

    public static String getSigilInfoByHouseName(String houseName) {
      return vesterosHouses.values().stream()
          .filter(house -> houseName.equals(house.getName()))
          .findFirst()
          .orElseThrow(() -> new IllegalArgumentException("House not found"))
          .getSigil();
    }

    public static void printHousesInfo() {
      vesterosHouses.forEach(((name, house) -> log.info(String.format("%s: %s", name, house.getSigil()))));
    }
  }
}
