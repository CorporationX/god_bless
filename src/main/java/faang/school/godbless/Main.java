package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Map<String, House> houses = new HashMap<>();
    houses.put("Stark", new House("Stark", "Wolf"));
    houses.put("Lannister", new House("Lannister", "Lion"));
    houses.put("Baratheon", new House("Baratheon", "Deer"));
    addHouse(new House("Targaryen", "Dragon"), houses);
    deleteHouse("Lannister", houses);
    House starkHouse = findHouseByName("Stark", houses);
    List<House> allHouses = getAllHouses(houses);

  }

  public static void addHouse(House house, Map<String, House> houses) {
    houses.put(house.getName(), house);
  }
  public static Map<String, House> deleteHouse(String name, Map<String, House> houses) {
    houses.remove(name);
    return houses;
  }
  public static House findHouseByName(String name, Map<String, House> houses) {
    return houses.get(name);
  }
  public static List<House> getAllHouses(Map<String, House> houses) {
    return new ArrayList<>(houses.values());
  }
}
