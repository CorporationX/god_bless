package school.faang.paveTheWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListsInitializer {
    private static final Random rand = new Random();

    public static List<City> initializeCitiesList() {
        List<City> cities = new ArrayList<>();
        List<String> cityNames = Arrays.asList("Novigrad", "Oxenfurt", "Vizima",
                "Beauclair", "Toussaint", "Cintra", "Rivia", "Vizima", "Kaer Morhen",
                "Ard Carraigh", "Ban Ard", "Tretogor", "Gors Velen", "Vengerberg", "Murivel");
        for (String cityName : cityNames) {
            cities.add(new City(cityName, new Location(rand.nextInt(-500, 500), rand.nextInt(-500, 500))));
        }
        return cities;
    }

    public static List<Monster> initializeMonstersList() {
        List<Monster> monsters = new ArrayList<>();
        List<String> monsterNames = Arrays.asList("Leshen", "Drowner",
                "Griffin", "Ekimma", "Striga", "Alghoul", "Fiend", "Godling",
                "Basilisk", "Wyvern", "Fleder", "Katakan", "Wraith", "Hym", "Kikimore");
        for (String monsterName : monsterNames) {
            monsters.add(new Monster(monsterName, new Location(rand.nextInt(-500, 500), rand.nextInt(-500, 500))));
        }
        return monsters;
    }
}
