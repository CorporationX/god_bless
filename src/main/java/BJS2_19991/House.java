package BJS2_19991;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class House {
    private String name;
    private String sigil;
    private Map<String, House> housesStorage;

    private House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public House() {
        housesStorage = new HashMap<>();
    }

    public void add(String name, String sigil) {
        House house = new House(name, sigil);
        housesStorage.put(name, house);
    }

    public void removeByName(String name) {
        housesStorage.remove(name);
    }

    public House find(String name) {
        return housesStorage.get(name);
    }

    public void printSigilByHouseName(String name) {
        House house = this.find(name);

        if (house.getSigil() != null) {
            System.out.println(house.getSigil());
        } else {
            System.out.println("No such house");
        }
    }

    public void printAllHouses() {
        for (Map.Entry<String, House> entry : housesStorage.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
