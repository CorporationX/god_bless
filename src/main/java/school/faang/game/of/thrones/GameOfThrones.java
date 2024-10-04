package school.faang.game.of.thrones;

import java.util.HashMap;

public class GameOfThrones {
    private HashMap<String, House> vesterosHouses;

    public GameOfThrones() {
        this.vesterosHouses = new HashMap<>();
    }

    public void addHouse(House house) {
        vesterosHouses.put(house.getName(), house);
    }

    public void deleteHouse(String name) {
        vesterosHouses.remove(name);
    }

    public House findHouse(String name) {
        House house = vesterosHouses.get(name);
        if (house != null) {
            System.out.println("Sigil: " + house.getSigil());
        }
        return house;
    }

    public void printAllHouses() {
        vesterosHouses.values().forEach(System.out::println);
    }
}
