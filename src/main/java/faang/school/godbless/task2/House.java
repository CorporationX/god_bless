package faang.school.godbless.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class House {
    private String name;
    private String sigil;

    public static void addHouse(Map<String, House> map, String name, House house) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The key must contain the name of the house");
        } else {
            map.put(name, house);
        }
    }

    public static void removeHouse(Map<String, House> map, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (map.containsKey(name)) {
            map.remove(name);
        } else {
            throw new IllegalArgumentException("House not found");
        }
    }

    public static void searchOfHouseAndShowInfo(Map<String, House> map, String sigil) {
        if (sigil == null || sigil.isBlank()) {
            throw new IllegalArgumentException("Sigil cannot be null or blank");
        }
        boolean isFoundSigil = false;
        for (Map.Entry<String, House> entry : map.entrySet()) {
            String value = entry.getValue().getSigil();
            if (value.equalsIgnoreCase(sigil)) {
                System.out.println(entry.getValue().getName() + " - " + entry.getValue().getSigil());
                isFoundSigil = true;
                break;
            }
        }
        if (!isFoundSigil) {
            throw new IllegalArgumentException("Sigil not found");
        }
    }

    public static void showInfo(Map<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getValue().name + " - " + entry.getValue().sigil);
        }
    }
}