package school.faang.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, House> houseMap = new HashMap<>();

    public void addHouse(String name, String sigil) {
        houseMap.put(name, new House(name, sigil));
    }

    public void removeHouse(String name) {
        houseMap.remove(name);
    }

    public void findHouse(String name) {
        House house = houseMap.get(name);
        if (house != null) {
            System.out.println(house);
        } else
            System.out.println("Дом не найден: " + name);
    }

    public void listHose() {
        if (houseMap.isEmpty()) {
            System.out.println("Нет доступных домов");
        } else {
            for (Map.Entry<String, House> entry : houseMap.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addHouse("Старк", "черный");
        main.addHouse("Ланнистер", "красный");
        main.addHouse("Баратеон", "белый");

        System.out.println("Cписок всех домов");
        main.listHose();

        System.out.println("\nПоиск дом 'Старк' :");
        main.findHouse("Старк");

        System.out.println("\nУдаление дома 'Ланнистер'");
        main.removeHouse("Ланнистер");

        System.out.println("\nСписок всех дома после удаления");
        main.listHose();
    }
}
