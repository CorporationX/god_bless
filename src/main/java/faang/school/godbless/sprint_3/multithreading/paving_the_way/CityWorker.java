package faang.school.godbless.sprint_3.multithreading.paving_the_way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
public class CityWorker implements Runnable {
    City currentCity;
    List<Monster> monsters;
    Map<String, Rank> monsterBookWithRanks;

    @Override
    public void run() {
        System.out.println("It's time to go, where the closest enemy?");
        System.out.printf("%s is the closest enemy in city %s%n", getMonsterName(), getCityName());
        int killTime = getKillTime(getMonsterName());
        System.out.printf("To kill this monster I need %d hours%n", killTime);
        System.out.println("I must start my journey, and kill " + getMonsterName());
        System.out.println("You successfully killed " + getMonsterName());
        System.out.println("Your traveling took about " + getTotalTravelTime() + " hours!");
    }

    private Pair getNearestEnemyNameAndLocation() {
        Optional<Pair> optionalPair = currentCity.getNearestCities()
                .keySet()
                .stream()
                .flatMap(cityName -> monsters.stream()
                        .filter(monster -> cityName.equals(monster.getLocation()))
                        .map(monster -> new Pair(cityName, monster.getName())))
                .min(Comparator.comparingInt(pair -> currentCity.getNearestCities().get(pair.getCityName())));
        return optionalPair.orElseGet(() -> new Pair("Буткемп", "Многопоточность"));

    }

    private int getKillTime(String monsterName) {
        Rank curentMonsterRank = monsterBookWithRanks.get(monsterName);
        return curentMonsterRank.getRank();
    }

    private int getTotalTravelTime() {
        Pair pair = getNearestEnemyNameAndLocation();
        int killTime = getKillTime(pair.getMonsterName());
        int kilometers = currentCity.getNearestCities().get(pair.getCityName());
        return ((kilometers * 12) / 60) + killTime;
    }

    private String getCityName() {
        return getNearestEnemyNameAndLocation().getCityName();
    }

    private String getMonsterName() {
        return getNearestEnemyNameAndLocation().getMonsterName();
    }
}