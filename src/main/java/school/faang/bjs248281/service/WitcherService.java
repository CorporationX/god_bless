package school.faang.bjs248281.service;

import lombok.RequiredArgsConstructor;
import school.faang.bjs248281.model.City;
import school.faang.bjs248281.model.Location;
import school.faang.bjs248281.model.Monster;
import school.faang.bjs248281.util.Constants;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class WitcherService implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        double distanceFromCastle = Location.getDistance(city.location(), Constants.WITCHER_CASTLE);
        monsters.stream()
                .min(Comparator.comparingDouble(monster -> Location.getDistance(monster.location(), city.location())))
                .ifPresentOrElse(
                        monster -> System.out.println("Distance from castle:" + distanceFromCastle + " city: "
                                + city.name() + " "
                                + ", nearest monster: " + monster
                                + ", summary distance: "
                                + (distanceFromCastle + Location.getDistance(monster.location(), city.location()))),
                        () -> System.out.println(city + " don't have monsters."));
    }
}
