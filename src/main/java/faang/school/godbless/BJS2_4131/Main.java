package faang.school.godbless.BJS2_4131;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, House> gameOfThronesFamilies = new HashMap<>();

        House stark = new House("Старк", "Волк");
        House lannister = new House("Ланнистер", "Золотой лев");
        House baratheon = new House("Баратеон", "Чёрный коронованный олень, стоящий на задних ногах, на золотом поле");

        House.addHouse(stark, gameOfThronesFamilies);
        House.addHouse(lannister, gameOfThronesFamilies);
        House.addHouse(baratheon, gameOfThronesFamilies);

        House.printAllHouses(gameOfThronesFamilies);

        House.removeHouse(stark, gameOfThronesFamilies);
        System.out.printf("Удалили дом \"%s\"", stark.getName());

        House.printAllHouses(gameOfThronesFamilies);

        System.out.println(House.findSigil(lannister.getName(), gameOfThronesFamilies));
    }
}
