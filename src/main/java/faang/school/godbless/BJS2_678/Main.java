package faang.school.godbless.BJS2_678;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        House Stark = new House("Старк", "Символ Старков");
        House Lannisters = new House("Ланнистеры", "Символ Ланнистеров");

        HashMap<String, House> houseWSymbol = new HashMap<>();
        houseWSymbol.put("Старк", Stark);
        houseWSymbol.put("Ланистеры", Lannisters);


        addInMap(houseWSymbol, "Баратеоны", "Символ Баратеонов");
        deleteInMap(houseWSymbol, "Ланнистеры");
        searchInMap(houseWSymbol, "Баратеоны");
    }

    private static void addInMap(HashMap<String, House> houseWSymbol, String name, String symbol) {
        houseWSymbol.put(name, new House(name, symbol));
    }

    private static void deleteInMap(HashMap<String, House> houseWSymbol, String name) {
        houseWSymbol.remove(name);
    }

    private static void searchInMap(HashMap<String, House> houseWSymbol, String name) {
        houseWSymbol.get(name);
    }
}
