package faang.school.godbless.multithreading.way;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CityWorker implements Runnable {

    private static Map<String, City> nameCities;
    private City city;
    private static final String DEFAULT_CITY = "Kaer Morhen";
    private static List<Monster> monsters;

    public CityWorker(City city) {
        this.city = city;
    }

    public static void setNameCities(List<City> cities) {
        nameCities = cities.stream().collect(Collectors.toMap(City::name, city -> city));
    }

    public static void setMonsters(List<Monster> paramMonsters) {
        monsters = paramMonsters;
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster();
        long ttk = getKillTime(monster);

        System.out.println("Ближайший монстр: " + monster);
        System.out.println("Время убийства монстра " + monster + " составляет " +  ttk + " секунд.");
    }

    public Monster findNearestMonster() {
        return monsters.stream()
                .sorted((m1, m2) -> {
                    try {
                        double result = calculateDistance(nameCities.get(m1.cityName()).location(), city.location())
                                - calculateDistance(nameCities.get(m2.cityName()).location(), city.location());
                        if (result > 0) {
                            return 1;
                        } else if (result < 0) {
                            return -1;
                        } else {
                            return 0;
                        }
                    } catch (NullPointerException e) {
                        throw new NullPointerException("\nВведенного города '" + m1.cityName() + "' нет в списке городов");
                    }
                })
                .limit(1)
                .toList().get(0);
    }

    public long getKillTime(Monster monster) {
        return monster.complexityKill();
    }

    public double getJourneyDistance() {
        return calculateDistance(city.location(), nameCities.get(DEFAULT_CITY).location());
    }

    public double calculateDistance(Location location1, Location location2) {
        double diffX = Math.pow(location1.x() - location2.x(), 2);
        double diffY = Math.pow(location1.y() - location2.y(), 2);

        return Math.pow(diffX + diffY, 0.5);
    }

}
