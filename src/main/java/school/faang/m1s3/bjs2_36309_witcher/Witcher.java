package school.faang.m1s3.bjs2_36309_witcher;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class Witcher {
    private final String name;
    private final Location witcherLocation = new Location();

    public void questLocator(List<City> cities, List<Monster> monsters) {
        List<CityWorker> quests = prepareQuests(cities, monsters);
        calculateQuestRoutes(quests);
        sortQuests(quests);
    }

    private List<CityWorker> prepareQuests(List<City> cities, List<Monster> monsters) {
        return cities.stream()
                .map(city -> new CityWorker(this, city, monsters))
                .toList();
    }

    private void calculateQuestRoutes(List<CityWorker> quests) {
        ExecutorService service = Executors.newFixedThreadPool(quests.size());
        quests.forEach(cityWorker -> service.submit(cityWorker));
        service.shutdown();

        try {
            if (!service.awaitTermination(5, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }

    private void sortQuests(List<CityWorker> quests) {
        quests.stream()
                .map(quest -> quest.getNearestMonster())
                .flatMap(nearestMonster -> nearestMonster.entrySet().stream())
                .sorted(Map.Entry.comparingByValue())
                .limit(1)
                .forEach(entry -> {

                    System.out.printf("Nearest monster is %s. It can be reached from %s city.%n",
                            entry.getKey().getMonster().getName(),
                            entry.getKey().getCity().getName());
                    System.out.printf("It is %.0f miles from your location%n", entry.getValue());
                });
    }
}
