package school.faang.laypathwithyourfinger;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Location castleLocation = new Location(0, 0);

        double distanceToCity = castleLocation.distanceTo(city.getLocation());

        Optional<Monster> closestMonster = monsters.stream()
                .min((m1, m2) -> Double.compare(
                        city.getLocation().distanceTo(m1.getLocation()),
                        city.getLocation().distanceTo(m2.getLocation())
                ));

        if (closestMonster.isPresent()) {
            Monster monster = closestMonster.get();
            double distanceToMonster = city.getLocation().distanceTo(monster.getLocation());

            System.out.println("Route: Castle -> " + city.getName() + " -> "
                    + monster.getName() + " | Total Distance: "
                    + (distanceToCity + distanceToMonster));
        }
    }
}

