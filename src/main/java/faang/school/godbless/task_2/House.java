package faang.school.godbless.task_2;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Getter
public class House {
    private String name;
    private String sigil;

    Map<String, House> mapHouses = new HashMap<>();

    public House(Map<String, House> mapHouses) {
        this.mapHouses = mapHouses;
    }

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public void addHouse(String name, House house) {
        if (!mapHouses.containsKey(name)) {
            mapHouses.put(name, house);
        } else {
            System.out.println("Map already contains this house!\n");
        }
    }

    public void removeHouse(String name) {
        if (mapHouses.containsKey(name)) {
            mapHouses.remove(name);
        } else {
            System.out.println("Map not contains this house!\n");
        }
    }

    public void searchHouse(String name) {
        if (mapHouses.containsKey(name)) {
            System.out.println(mapHouses.get(name).getName() + " sigil is: " + mapHouses.get(name).getSigil() + '\n');
        } else {
            System.out.println("Map not contains this house!\n");
        }
    }

    public void getHousesAndSigils() {
        mapHouses.forEach((key, value) -> System.out.println(key + ":" + value + '\n'));
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }
}
