package school.faang.bjs2_89858;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final int X_LOCATION_THE_WITCHER = 0;
    private static final int Y_LOCATION_THE_WITCHER = 0;
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Location location = city.getLocation();
        double distanceToTheCastle = determineDistanceToTheCastle(location.getXlocation(), location.getYlocation());

        log.info("Distance from the witcher's castle to the city {} - {}", city.getName(), distanceToTheCastle);

        Monster monster = determineTheNearestMonster();
        double distanceToMonster = calculateThePythagoreanTheorem(monster.getLocation().getXlocation(),
                monster.getLocation().getYlocation(),
                X_LOCATION_THE_WITCHER,
                Y_LOCATION_THE_WITCHER);
        log.info("The nearest monster {} will be found at a distance {} from the city {}", monster.getName(),
                distanceToMonster,
                city.getName());
    }

    private double determineDistanceToTheCastle(int x, int y) {

        return calculateThePythagoreanTheorem(x, y, X_LOCATION_THE_WITCHER, Y_LOCATION_THE_WITCHER);
    }

    private Monster determineTheNearestMonster() {
        Optional<Monster> closestMonster = monsters.stream()
                .min(Comparator
                        .comparingDouble(monster ->
                                calculateThePythagoreanTheorem(monster.getLocation().getXlocation(),
                                        monster.getLocation().getYlocation(),
                                        X_LOCATION_THE_WITCHER,
                                        Y_LOCATION_THE_WITCHER)));

        Monster monster = closestMonster.get();
        if (closestMonster.isPresent()) {
            return monster;
        } else {
            log.error("The city {} has no monsters", city.getName());
            throw new RuntimeException();
        }

    }

    private double calculateThePythagoreanTheorem(int x, int y, int x0, int y0) {
        int lengthX = x0 - x;
        int lengthY = y0 - y;
        double sqrt = Math.sqrt(Math.pow(lengthX, 2) + Math.pow(lengthY, 2));
        return sqrt;
    }
}
