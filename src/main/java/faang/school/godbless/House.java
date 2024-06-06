package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

import static faang.school.godbless.Application.houseMap;


@Data
@AllArgsConstructor
@ToString
public class House {
    private String name;
    private String sigil;


    public static void addHouse(House house) {
        if (house != null) {
            houseMap.put(house.getName(), house);
        } else {
            System.out.println("House is null, cannot add house");
        }
    }

    public static void removeHouse(String house) {
        if (house != null) {
            houseMap.remove(house);
        } else {
            System.out.println("House is null, cannot remove house");
        }
    }

    public static void printHouses() {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            House house = entry.getValue();
            System.out.println("House: " + house.getName() + "Sigil " + house.getSigil());
        }
    }

    public static void findHouseByName(String housename) {
        if (housename != null) {
            House house1 = houseMap.get(housename);
            if (house1 != null) {
                System.out.println("House: " + house1.getName() + "Sigil " + house1.getSigil());
            } else {
                System.out.println("House is null, cannot find house" + housename);
            }
        }
    }

}

