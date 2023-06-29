package faang.school.godbless.sprint_3.multithreading.paving_the_way;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        Map<String, Rank> monsterBookWithRanks = new HashMap<>();

        monsterBookWithRanks.put("Griffin", new Rank(3));
        monsterBookWithRanks.put("Basilisk", new Rank(5));
        monsterBookWithRanks.put("Bruksa", new Rank(3));
        monsterBookWithRanks.put("Cockatrice", new Rank(2));
        monsterBookWithRanks.put("Chort", new Rank(1));
        monsterBookWithRanks.put("Sukub", new Rank(2));

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Novigrad")); // 0
        monsters.add(new Monster("Basilisk", "Vizima")); // 120
        monsters.add(new Monster("Bruksa", "Malduer")); // 60
        monsters.add(new Monster("Cockatrice", "Kaer Morhen")); // 180
        monsters.add(new Monster("Chort", "Skelige")); //60
        monsters.add(new Monster("Sukub", "Velen")); //----

        List<City> cities = new ArrayList<>();

        Map<String, Integer> firstList = new HashMap<>();
        firstList.put("Oxenfurt", 10);
        firstList.put("Vizima", 20);
        firstList.put("Kaer Morhen", 40);

        Map<String, Integer> secondCity = new HashMap<>();
        secondCity.put("Novigrad", 10);
        secondCity.put("Vizima", 10);
        secondCity.put("Kaer Morhen", 30);

        Map<String, Integer> thirdCity = new HashMap<>();
        thirdCity.put("Novigrad", 20);
        thirdCity.put("Oxenfurt", 10);
        thirdCity.put("Kaer Morhen", 20);

        Map<String, Integer> fourthCity = new HashMap<>();
        fourthCity.put("Novigrad", 40);
        fourthCity.put("Oxenfurt", 30);
        fourthCity.put("Vizima", 20);

        cities.add(new City("Novigrad", 0, firstList));
        cities.add(new City("Oxenfurt", 60, secondCity));
        cities.add(new City("Vizima", 120, thirdCity));
        cities.add(new City("Kaer Morhen", 180, fourthCity));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters, monsterBookWithRanks));
        }
        executorService.shutdown();
    }
}
