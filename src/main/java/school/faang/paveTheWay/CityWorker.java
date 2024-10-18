package school.faang.paveTheWay;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Location castle = new Location(0, 0);
        Location cityLocation = city.getLocation();
        double cityDistance = castle.distanceTo(city);
        Monster minMonster = monsters.stream()
                .min(Comparator.comparingDouble(
                        monster -> cityLocation.distanceTo(monster)))
                .orElseThrow(() -> new IllegalArgumentException("The list is empty"));
        double minMonsterDistance = cityLocation.distanceTo(minMonster);

        System.out.println("The distance from the castle to the destination city: " + cityDistance);
        System.out.println("The distance from the castle to the nearest monster: " + minMonsterDistance);
    }
}
