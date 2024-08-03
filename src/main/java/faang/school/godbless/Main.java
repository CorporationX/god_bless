package faang.school.godbless;


import java.util.HashMap;
import java.util.Map;

public class Main {

    public static HashMap<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        House faang = new House("Faang", "White Logo");
        houses.put("Stark", new House("Stark", "Direwolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Targaryen", new House("Targaryen", "Dragon"));

        addHouse(faang);
        deleteHouse("Stark");
        System.out.println(getHouseSigil(houses, "Faang"));
        System.out.println(printAllHouseAndSigil(houses));
    }

    public static void addHouse(House house) {
        if (houses.containsKey(house.getName())) {
            System.out.println("Дом уже добавлен в список");
        } else {
            houses.put(house.getName(), house);
            System.out.println("Дом: " + house.getName() + " был добавлен");
        }
    }

    public static void deleteHouse(String houseName) {
        if (!houses.containsKey(houseName)) {
            System.out.println("Такого дома нет в списке");
        } else {
            houses.remove(houseName);
            System.out.println("Дом: " + houseName + " был удален.");
        }
    }

    public static String getHouseSigil(HashMap<String, House> houses, String houseName) {
        System.out.println("Поиск герба для дома: " + houseName + ":");
        if (!houses.containsKey(houseName)) {
            return "Такого дома нет в списке";
        }
        House result = houses.get(houseName);
        return result.getSigil();
    }

    public static String printAllHouseAndSigil(HashMap<String, House> houses) {
        StringBuilder result = new StringBuilder();
        System.out.println("\nСписок всех домов!");
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            House house = entry.getValue();
            result.append("Дом: ").append(house.getName()).append(", Герб: ").append(house.getSigil()).append("\n");
        }
        return result.toString();
    }
}

