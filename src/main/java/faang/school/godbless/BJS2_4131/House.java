package faang.school.godbless.BJS2_4131;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    public static void addHouse(House house, Map<String, House> target) {
        target.put(house.getName(), house);
    }

    public static void removeHouse(House house, Map<String, House> target) {
        target.remove(house.getName());
    }

    public static String findSigil(String houseName, Map<String, House> target) {
        House house = target.get(houseName);

        if (house == null) {
            throw new IllegalArgumentException(String.format("Дом \"%s\" не найден", houseName));
        }

        return house.getSigil();
    }

    public static void printAllHouses(Map<String, House> target) {
        System.out.println("Список всех домов и их гербов:");

        for (House house : target.values()) {
            System.out.printf("Дом \"%s\", Герб \"%s\".%n", house.getName(), house.getSigil());
        }
    }
}
