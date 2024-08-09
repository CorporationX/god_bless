package faang.school.godbless.BJS2_19999;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Main {
    private Map<String, House> houseMap = new HashMap<>();

    public void addHouse(House house) {
        houseMap.put(house.getName(), house);
    }

    public void removeHouse(String name) {
        houseMap.remove(name);
    }

    public void findHouse(String name) {
        House house = houseMap.get(name);
        if (house != null) {
            System.out.println("Дом: " + house.getName() + ", Герб: " + house.getSigil());
        } else {
            System.out.println("Такого дома нет");
        }
    }

    public void printAllHouses() {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println("Дом: " + entry.getValue().getName() + ", Герб: " + entry.getValue().getSigil());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.addHouse(new House("Старки", "Волк"));
        main.addHouse(new House("Ланистеры", "Лев"));
        main.addHouse(new House("Таргариены", "Драконы"));

        System.out.println("Все дома:");
        main.printAllHouses();

        System.out.println("Поиск дома Старков:");
        main.findHouse("Старки");

        System.out.println("Удаление дома Таргариенов:");
        main.removeHouse("Таргариены");

        System.out.println("Все дома после удаления Таргариенов:");
        main.printAllHouses();

        System.out.println("Поиск дома Таргариенов:");
        main.findHouse("Таргариены");

        System.out.println("Добавление дома 'Грэйджои':");
        main.addHouse(new House("Грейджои", "Кракен"));

        System.out.println("Все дома после добавления Грейджоев:");
        main.printAllHouses();
    }
}

