package school.faang.main_code_game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static HashMap<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        House lannisterHouse = new House("Lannister", "firstCoatOfArms");
        House starkHouse = new House("Stark", "secondCoatOfArms");
        House barateonHouse = new House("Barateon", "thirdCoatOfArms");

        main.addHouse(lannisterHouse);
        main.addHouse(starkHouse);
        main.addHouse(barateonHouse);

        main.removeHouse("Lannister");

        main.findHouseGerb("Stark");

        main.printAll();
    }


    public void addHouse(House house) {
        houseMap.put(house.getName(), house);
    }

    public void removeHouse(String name) {
        houseMap.remove(name);
    }

    public void findHouseGerb(String name) {
        System.out.println(houseMap.get(name).getCoatOfArms());
    }

    public void printAll() {
        for(Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
