package faang.school.godbless.BJS2_8191;

import java.util.HashMap;

public class Main {
    private HashMap<String, House> houses = new HashMap<>();

    public Main() {
        addNewHouse(new House("Старк", "stark"));
        addNewHouse(new House("Ланнистер", "lanister"));
        addNewHouse(new House("Баратеон", "barteon"));
    }


    public void addNewHouse(House house) {
        if (house != null)
            houses.put(house.getName(), house);
    }

    public void deleteHouseByName(String name) {
        if (name != null) {
            if (houses.get(name) == null) {
                throw new IllegalArgumentException("Такого дома нет");
            }

            houses.remove(name);
        }
    }

    public String findHouseByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя дома пустое");
        }
        return houses.get(name).getSigil();
    }

    public void findAllHouses() {
        houses.forEach((key, value) -> System.out.println("Дом: " + key + " - Герб:" + value.getSigil()));
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.deleteHouseByName("888");
        main.findAllHouses();
    }
}
