package school.faang.finger_point_way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Objects.requireNonNull(monsters, "список monsters не может быть null");
        //не знаю ок ли выбрасывать NPE или лучше через if выбросить например IllegalStateException

        double xlocation = city.getLocation().getXxVal();
        double ylocation = city.getLocation().getYyVal();
        double distanceCastleToCity = Math.sqrt(xlocation * xlocation + ylocation * ylocation);

        Map.Entry<Monster, Double> monsterToDistanceEntry = monsters.stream()
                .map(monster -> Map.entry(monster, calculateDistanceBetween(city.getLocation(), monster.getLocation())))
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("пустой список monsters"));
        double minDistanceToMonster = monsterToDistanceEntry.getValue();
        Monster closestMonster = monsterToDistanceEntry.getKey();
        double distanceCastleToMonster = distanceCastleToCity + minDistanceToMonster;

        System.out.printf("Расстояние от замка Ведьмака (координаты (0, 0)) до города %s - %.1f%n",
                city.getName(), distanceCastleToCity);
        System.out.printf("Расстояние от города %s (координаты (%s, %s)) до ближайшего монстра - %.1f%n",
                city.getName(), city.getLocation().getXxVal(), city.getLocation().getYyVal(), minDistanceToMonster);
        System.out.printf("Расстояние от замка до города плюс расстояние от города %s до ближайшего " +
                        "монстра " + "составляет %.1f часов. " + "Выбранная цель %s%n", city.getName(),
                distanceCastleToMonster, closestMonster.getName());
    }

    private double calculateDistanceBetween(Location location1, Location location2) {
        double xdistance = Math.abs(location1.getXxVal() - location2.getXxVal());
        double ydistance = Math.abs(location1.getYyVal() - location2.getYyVal());
        return Math.sqrt(xdistance * xdistance + ydistance * ydistance);
    }
}
