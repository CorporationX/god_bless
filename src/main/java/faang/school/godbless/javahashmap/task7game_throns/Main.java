package faang.school.godbless.javahashmap.task7game_throns;

import java.util.HashMap;

public class Main {
    private static HashMap<String,House> houses = new HashMap<>();
    public static void main(String... args) {
        initHouses();
        addHouse(new House("Балтика", "9"));
        removeHouse("hhj");
        removeHouse("Балтика");
        infoHouse("gfh");
        infoHouse("Старк");
        infoHouses();
    }

    public static void initHouses(){
        House house1 = new House("Старк", "Лютоволк");
        House house2 = new House("Ланнистер", "Лев");
        House house3 = new House("Баратеон", "Олень");

        houses.put(house1.getName(), house1);
        houses.put(house2.getName(), house2);
        houses.put(house3.getName(), house3);
        System.out.println("Дома добавлены");
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
        System.out.println("Дом " + house.getName() + " добавлен");
    }

    public static void removeHouse(String currentNameHouse) {
        for (String nameHouse: houses.keySet()) {
            if (currentNameHouse.equals(nameHouse)) {
                houses.remove(currentNameHouse);
                System.out.println("Удаление дома " + nameHouse + " прошло успешно");
                return;
            }
        }
        System.out.println("Удаление невозможно, нет дома с названием " + currentNameHouse);
    }

    public static void infoHouse(String currentNameHouse) {
        for (String nameHouse: houses.keySet()) {
            if (currentNameHouse.equals(nameHouse)) {
                System.out.println("Герб дома " + nameHouse + ": " + houses.get(nameHouse).getSigil());
                return;
            }
        }

        System.out.println("Получение информации невозможно, нет дома названием " + currentNameHouse);
    }

    public static void infoHouses() {
        System.out.println("Список домов:");
        System.out.println("*********************************");

        for (House house: houses.values()) {
            System.out.println("Герб дома " + house.getName() + ": " + houses.get(house.getName()).getSigil());
        }

        System.out.println("*********************************");
    }
}
