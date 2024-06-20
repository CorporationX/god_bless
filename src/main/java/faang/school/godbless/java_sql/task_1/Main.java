package faang.school.godbless.java_sql.task_1;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        HashMap<String, House> houseHashMap = new HashMap<>();
        var firstHouse = new House("Старки", "Голова серого лютоволка на бело-зелёном фоне");
        var secondHouse = new House("Ланнистеры", "Золотой лев, стоящий на задних лапах, на " +
                "малиновом поле");
        var thirdHouse = new House("Баратеоны", "Чёрный коронованный олень, стоящий на задних " +
                "ногах, на золотом поле");
        var fourthHouse = new House("Грейджои", "Золотой кракен на чёрном фоне");
        var fifthHouse = new House("Мартеллы", "Красное солнце, пронзённое золотым копьём, на " +
                "оранжевом фоне");

        addHouse(houseHashMap, firstHouse);
        addHouse(houseHashMap, secondHouse);
        addHouse(houseHashMap, thirdHouse);
        addHouse(houseHashMap, fourthHouse);
        addHouse(houseHashMap, fifthHouse);
        printAllHouses(houseHashMap);
        System.out.println("----------------------------");
        deleteHouse(houseHashMap, thirdHouse.getName());
        printAllHouses(houseHashMap);
        System.out.println("----------------------------");
        printHouseSigil(houseHashMap, firstHouse.getName());
    }

    static void addHouse(HashMap<String, House> houseHashMap, House house) {
        houseHashMap.put(house.getName(), house);
    }

    static void deleteHouse(HashMap<String, House> houseHashMap, String houseName) {
        houseHashMap.remove(houseName);
    }

    static void printHouseSigil(HashMap<String, House> houseHashMap, String houseName) {
        System.out.println(houseHashMap.get(houseName).getSigil());
    }

    static void printAllHouses(HashMap<String, House> houseHashMap) {
        houseHashMap.keySet().forEach(houseName ->
                System.out.println("House: " + houseName + ", sigil: " + houseHashMap.get(houseName).getSigil())
        );
    }
}
