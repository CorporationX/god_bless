package module_3.module_3_1_Parallelism_Thread.leadTheWayWithYourFinger_36590;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;

    private double getDist(Location loc1, Location loc2) {
        int valueX = loc1.x() - loc2.x();
        int valueY = loc1.y() - loc2.y();
        return Math.sqrt(Math.pow(valueX, 2) + Math.pow(valueY, 2));
    }

    @Override
    public void run() {
        double distToCity = getDist(new Location(0, 0), city.getLocation());
        Optional<Monster> monster = monsters.stream()
                .min((m1, m2) -> Double.compare(getDist(m1.getLocation(), city.getLocation()),
                        getDist(m2.getLocation(), city.getLocation())));
        monster.ifPresent(value -> System.out.printf("Расстояние до города %s + ближайшего монстра %s: %.1f\n",
                city.getName(), value.getName(), (distToCity + getDist(value.getLocation(), city.getLocation())))
        );

        if (monster.isEmpty()) {
            System.out.println("Монстры кончились, сиди дома!");
        }

    }
}
