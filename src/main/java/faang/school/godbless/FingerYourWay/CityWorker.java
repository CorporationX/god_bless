package faang.school.godbless.FingerYourWay;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final Random RANDOM = new Random();
    private City city;
    private List<Monster> monsters;

    public Optional<Monster> findNearestMonster(City city, List<Monster> monsters) {
        return considerTheNearestMonster(city, monsters);
    }

    public long getKillTime() {
        return RANDOM.nextInt(5, 30);
    }

    public long getJourneyDistance(Monster monster, City city) {
        return distanceBetweenMonsterAndCity(monster, city);
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters)
                .orElseThrow(() -> new NoSuchElementException("Монстр не найден"));
        System.out.println("Ближайший монстр - " + monster.getName());

        long walkTime = getJourneyDistance(monster, city);
        System.out.println("Дистанция до цели - " + walkTime);

        long killTime = getKillTime();
        System.out.println("Бой длится - " + killTime + " часов");
        try {
            Thread.sleep(killTime);
            System.out.println("Бой закончен");
        } catch (InterruptedException e) {
            throw new RuntimeException("Прерывание потока - ведьмак не смог убить монстра (кончились бутыльки с Ласточкой)");
        }
    }

    private Optional<Monster> considerTheNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min(Comparator.comparingDouble(i -> distanceBetweenMonsterAndCity(i, city)));
    }

    private long distanceBetweenMonsterAndCity(Monster monster, City city) {
        return (long) Math.sqrt(Math.pow(
                (city.getLocation().getX() - monster.getLocation().getX()), 2) +
                Math.pow((city.getLocation().getY() - monster.getLocation().getY()), 2));
    }
}
