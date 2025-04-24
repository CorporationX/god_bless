package school.faang.put_the_path_with_your_finger;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        double distanceToCity = calculateDistance(new Location(0, 0), city.getLocation());

        Monster nearestMonster = findNearestMonster();

        if (nearestMonster != null) {
            double distanceToMonster = calculateDistance(city.getLocation(), nearestMonster.getLocation());
            double totalDistance = distanceToCity + distanceToMonster;
            log.info("Город: {} | Монстр: {} | Общая дистанция: {}",
                    city.getName(), nearestMonster.getName(), totalDistance);
        } else {
            System.out.println("Город: " + city.getName() + " | Нет ближайших монстров");
        }
    }

    private Monster findNearestMonster() {
        if (monsters.isEmpty()) {
            return null;
        }

        Monster nearest = monsters.get(0);
        double minDistance = calculateDistance(city.getLocation(), nearest.getLocation());

        for (Monster monster : monsters) {
            double currentDistance = calculateDistance(city.getLocation(), monster.getLocation());
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                nearest = monster;
            }
        }

        return nearest;
    }

    private double calculateDistance(Location loc1, Location loc2) {
        double dx = loc1.getCoordX() - loc2.getCoordX();
        double dy = loc1.getCoordY() - loc2.getCoordY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершились вовремя, принудительно закрываем пул потоков...");
                executor.shutdownNow();
            } else {
                System.out.println("Все задачи выполнены успешно.");
            }
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            executor.shutdownNow();
        }
    }
}
