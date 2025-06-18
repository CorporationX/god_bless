package school.faang.sprint3.bjs2_81587;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        double distanceToCity = calculateDistance(new Location(0, 0), city.getLocation());
        double closestDistanceToMonster = !monsters.isEmpty()
                ? calculateDistance(city.getLocation(), monsters.stream().findFirst().get().getLocation())
                : distanceToCity;
        for (int i = 1; i < monsters.size(); i++) {
            double distanceToMonster = calculateDistance(city.getLocation(), monsters.get(i).getLocation());
            if (distanceToMonster < closestDistanceToMonster) {
                closestDistanceToMonster = distanceToMonster;
            }
        }
        System.out.printf(
                "Расстояние до города: %s, расстояние от города до монстра: %s\n",
                distanceToCity,
                closestDistanceToMonster
        );
    }

    private double calculateDistance(Location loc1, Location loc2) {
        return Math.sqrt(
                Math.pow(
                        loc1.getAxisX() - loc2.getAxisX(), 2) + Math.pow(loc1.getAxisY() - loc2.getAxisY(),
                        2)
        );
    }
}
