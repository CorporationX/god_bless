package faang.school.godbless.Witcher;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private final List<Monster> monsters;

    public Monster findNearestMonster() {
        if (monsters == null || monsters.isEmpty()) {
            throw new IllegalArgumentException("Monsters cannot be empty");
        }
        var closest = monsters.stream().collect(Collectors.toMap(
                        monster -> monster,
                        monster -> city.getLocation().calculateDistance(monster.getLocation()))
                ).entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();
        return closest.get(0).getKey();
    }

    public double getKillTime(Monster monster) {
        double strength = monster.getStrength();
        return strength / 5 + 50; // Решил такую формулу придумать
    }

    public double getJourneyDistance(Monster monster) {
        return city.getLocation().calculateDistance(monster.getLocation());
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Ближайший монстр: " + findNearestMonster().getName() + ", еду...");
        Thread.sleep(new Random().nextInt(1000, 5000));
        System.out.println("Добираться до монстра: " + findNearestMonster().getName() + " " + getJourneyDistance(findNearestMonster()));
        System.out.println("Убить монстра за: " + getKillTime(findNearestMonster()));
    }
}
