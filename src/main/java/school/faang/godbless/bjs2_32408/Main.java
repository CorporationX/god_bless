package school.faang.godbless.bjs2_32408;

import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final Map<String, House> housesMap = new HashMap<>();

  public static void main(String[] args) {
    House starkHouse = new House("Stark", "Wolf");
    addHouse(starkHouse);
    House baratheonHouse = new House("Baratheon", "Deer");
    addHouse(baratheonHouse);
    House lanisterHouse = new House("Lanister", "Lion");
    addHouse(lanisterHouse);
    printHouses();

    removeByHouseName("Lanister");
    printHouses();

    printSigil("Stark");
  }

  private static void addHouse(House house) {
    housesMap.put(house.getName(), house);
  }

  private static void removeByHouseName(String houseName) {
    housesMap.remove(houseName);
  }

  private static void printSigil(String houseName) {
    if (!housesMap.containsKey(houseName)) {
      throw new IllegalArgumentException("No such house");
    }
    System.out.println(housesMap.get(houseName).getSigil());
  }

  private static void printHouses() {
    System.out.println(housesMap);
  }
}
