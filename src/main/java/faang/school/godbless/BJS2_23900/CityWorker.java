package faang.school.godbless.BJS2_23900;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CityWorker {
    private Map<City, List<Monster>> cityByMonsters;

    private CityWorker(Map<City, List<Monster>> cityByMonsters) {
        this.cityByMonsters = cityByMonsters;
    }

    public static CityWorker create(List<City> cities, List<Monster> monsters) {
        return new CityWorker(cities.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        city -> monsters.stream()
                                .filter(monster -> monster.getCity().equals(city))
                                .toList(),
                        (list1, list2) -> list1,
                        () -> new TreeMap<>(Comparator.comparingInt(City::getDistance))
                ))
        );
    }

    public void start() {
        start(cityByMonsters.size());
    }

    public void start(int countThreads) {
        ExecutorService executor = Executors.newFixedThreadPool(countThreads);
        cityByMonsters.forEach((city, monsters) -> executor.execute(cleanCity(city, monsters)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private Runnable cleanCity(City city, List<Monster> monsters) {
        goCity(city);
        return () -> {
            System.out.printf("Начинается зачистка города: %s%n", city.getName());
            killMonsters(monsters);
            System.out.printf("Город %s зачищен от монстров!%n", city.getName());
        };
    }

    private void goCity(City city) {
        System.out.println("Nдем к городу: " + city.getName());
        waitProcess(city.getDistance() * 10L);
    }

    private void killMonsters(List<Monster> monsters) {
        monsters.forEach(monster -> {
            System.out.printf("Убиваем монстра: %s%n", monster.getName());
            waitProcess(monster.getPower() * 1000L / 2);
            System.out.printf("Монстр %s был убит!%n", monster.getName());
        });
    }

    private void waitProcess(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
