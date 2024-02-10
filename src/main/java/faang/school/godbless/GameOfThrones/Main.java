package faang.school.godbless.GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseAndSigil = new HashMap<>();
        houseAndSigil.put("Старк", new House("Старк", "Волк"));
        houseAndSigil.put("Ланистр", new House("Ланистр", "Лев"));
        houseAndSigil.put("Баратеон", new House("Баратеон", "Олень"));

        findHousesSigil(houseAndSigil, "Старк");
        printAllHouse(houseAndSigil);
        removeHouse(houseAndSigil, "Баратеон");
        printAllHouse(houseAndSigil);
        addHouse(houseAndSigil, "FAANGSchool", "Программист в Амстердаме");
        printAllHouse(houseAndSigil);
    }

    public static void addHouse(Map<String, House> houseAndSigil, String name, String sigil) {
        houseAndSigil.put(name, new House(name, sigil));
    }

    public static void removeHouse(Map<String, House> houseAndSigil, String name) {
        houseAndSigil.remove(name);
    }

    public static void findHousesSigil(Map<String, House> houseAndSigil, String name) {
        String sigil = houseAndSigil.get(name).toString();
        if (sigil != null) System.out.println("Гербом дома " + name + " является " + sigil);
    }

    public static void printAllHouse(Map<String, House> houseAndSigil) {
        for (Map.Entry<String, House> entry : houseAndSigil.entrySet()) {
            System.out.println("Дом " + entry.getKey() + ". Его герб - " + entry.getValue().toString());
        }
    }
}
