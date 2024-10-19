package school.faang.waywithfinger;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable{
    private static final Location CASTLE = new Location(0, 0);

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = calculateDistance(CASTLE, city.getLocation());
        double minDistanceToMonster = monsters.stream()
                .map(monster -> calculateDistance(monster.getLocation(), city.getLocation()))
                .min((a1, a2) -> (int) (a1 - a2))
                .get();
        System.out.println("Дистанция до ближайщего монстра около города " + city.getName() + " составляет "
                + (distanceToCity + minDistanceToMonster));

    }

    private Double calculateDistance(Location from, Location to) {
        int deltaX = from.getX() - to.getX();
        int deltaY = from.getY() - to.getY();
        return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
    }
}