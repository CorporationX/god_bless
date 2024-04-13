package gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {

        House baratheon = new House("Баратеоны ", "Чёрный коронованный олень на золотом поле");
        House lannister = new House("Ланнистеры ", "Золотой лев на красном поле");
        House stark = new House("Старки ", "Серый лютоволк на снежно-белом фоне");
        House greyjoy = new House("Грейджои ", "Золотой кракен на чёрном поле");

        addHouse(baratheon);
        addHouse(lannister);
        addHouse(stark);
        addHouse(greyjoy);

        deleteHouse(lannister.getName());

        showSigil(lannister.getName());
        showSigil(greyjoy.getName());

        showHouses();

    }

    public static void addHouse(House house) {
        houseMap.put(house.getName(), house);
    }

    public static void deleteHouse(String houseName) {
        houseMap.remove(houseName);
    }

    public static void showSigil(String houseName) {
        House house = houseMap.get(houseName);
        if (house != null) {
            System.out.println("у дома \"" + houseName + "\" герб: \"" + house.getSigil() + "\"");
        } else {
            System.out.println("Дом с названием \"" + houseName + "\" не найден в списке");
        }
    }

    public static void showHouses() {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println("имя дома: " + entry.getKey() + ", описание герба: " + entry.getValue().getSigil());
        }
    }

}
