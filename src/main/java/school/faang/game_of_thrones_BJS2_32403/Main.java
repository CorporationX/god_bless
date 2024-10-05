package school.faang.game_of_thrones_BJS2_32403;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Main {
    private Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addHouse(new House("Stark", "A grey direwolf on a white field"));
        main.addHouse(new House("Lannister", "A golden lion on a crimson field"));
        main.addHouse(new House("Targaryen", "A red three-headed dragon on a black field"));
        main.addHouse(new House("Baratheon", "A black crowned stag on a gold field"));

        main.findHouse("Lannister");
        main.printAllHouses();
        main.deleteHouse("Lannister");
        main.printAllHouses();

    }

    public void addHouse(House house) {
        if (houses.containsKey(house.getName())) {
            System.out.println("House with name " + house.getName() + " already exists");
        } else {
            houses.put(house.getName(), house);
        }
    }

    public void deleteHouse(String houseName) {
        if (!houses.containsKey(houseName)) {
            System.out.println("house with name " + houseName + " does not exist");
        } else {
            houses.remove(houseName);
        }
    }

    public void findHouse(String houseName) {
        if (!houses.containsKey(houseName)) {
            System.out.println("house with name " + houseName + " does not exist");
        } else {
            System.out.printf("Description of %s blazon : %s\n", houseName, houses.get(houseName).getBlazon());
        }
    }

    public void printAllHouses() {
        for (House house : houses.values()) {
            System.out.printf("House name - %s, House blazon - %s\n", house.getName(), house.getBlazon());
        }
    }


}
