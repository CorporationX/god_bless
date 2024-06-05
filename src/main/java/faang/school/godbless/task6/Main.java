package faang.school.godbless.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    private static final Map<String, House> sigilMap = new HashMap<>();

    public static void main(String[] args) {
        addHouse(sigilMap, new House("Старк", "Лютоволк"));
        addHouse(sigilMap, new House("Ланистер", "Лев"));
        addHouse(sigilMap, new House("Баратеон", "Олень"));
        addHouse(sigilMap, new House("Удалить", "Удалить"));
        removeHouseByName(sigilMap,"Удалить");
        findHouseByNameAndPrintSigil(sigilMap,"Старк");
        printAllHousesAndSigils(sigilMap);

    }

    public static void addHouse(Map<String, House> sigilMap, House house) {
        sigilMap.put(house.getSigil(), house);
    }

    public static void removeHouseByName(Map<String, House> sigilMap, String houseName) {
        sigilMap.remove(findEntryByHouseName(sigilMap, houseName).getKey());
    }

    public static void findHouseByNameAndPrintSigil(Map<String, House> sigilMap, String houseName) {
        Map.Entry<String, House> entry = findEntryByHouseName(sigilMap, houseName);
        printInfoAboutHouseSigil(entry.getValue().getName(), entry.getValue().getSigil());
    }

    public static void printAllHousesAndSigils(Map<String, House> sigilMap) {
        for (Map.Entry<String, House> entry : sigilMap.entrySet()) {
            printInfoAboutHouseSigil(entry.getValue().getName(), entry.getValue().getSigil());
        }
    }

    private static Map.Entry<String, House> findEntryByHouseName(Map<String, House> sigilMap, String houseName) {
        for (Map.Entry<String, House> entry : sigilMap.entrySet()) {
            if (entry.getValue().getName().equals(houseName))
                return entry;
        }
        throw new NoSuchElementException("ОшЫбка, элемент карты с именем дома: " + houseName + " - не найден (");
    }

    private static void printInfoAboutHouseSigil(String houseName, String sigil) {
        System.out.println("Гербом дома \"" + houseName + "\" является - " + sigil);
    }
}
