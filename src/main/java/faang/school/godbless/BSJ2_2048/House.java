package src.main.java.faang.school.godbless.BSJ2_2048;

import java.util.Map;

import static src.main.java.faang.school.godbless.BSJ2_2048.Main.map;

public class House {
    String name;
    String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }

    public static void addHouse(String name, String sigil) {
        House newHouse = new House(name, sigil);
        map.put(name, newHouse);
    }

    public static void deleteHouse(String name) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                map.remove(entry.getKey());
                break;
            }
        }
    }

    public static void SearchAndPrintHouse(String name) {
        if (map.containsKey(name)) {
            System.out.println(map.get(name).getSigil());
        }
    }

    public static void showHouseAndSigil() {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            String nameHouse = entry.getKey();
            String sigil = entry.getValue().getSigil();
            System.out.println(nameHouse + ":" + sigil);
        }
    }
}
