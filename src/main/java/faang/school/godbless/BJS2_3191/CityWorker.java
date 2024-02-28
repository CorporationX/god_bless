package faang.school.godbless.BJS2_3191;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Data
public class CityWorker implements Runnable {
    @NonNull
    private City city;
    @NonNull
    private List<Monster> monsters;
    @NonNull
    private List<City> cities;

    private Monster findNearestMonster(City city, List<Monster> monsters) {
        Optional<Monster> result = monsters.stream().min((monster1, monster2) -> getCityMonsterDistance(city, monster1) - getCityMonsterDistance(city, monster2));
        return result.orElse(null);
    }

    private int getDistance(Location sourceLocation, Location destinationLocation) {
        return Math.abs(sourceLocation.getX() - destinationLocation.getX()) + Math.abs(sourceLocation.getY() - destinationLocation.getY());
    }

    private int getCityMonsterDistance(City city, Monster monster) {
        return getDistance(city.getLocation(), getLocationByVillageName(monster.getVillageName()));
    }

    private int getKillTime() {
        return (new Random().nextInt(4) + 1) * 1000;
    }

    private int getJourneyDistance() {
        var witcherCity = cities.stream().min(Comparator.comparingInt(City::getWitcherDistance));
        if (witcherCity.isPresent()) {
            return getDistance(city.getLocation(), witcherCity.get().getLocation());
        } else {
            return Integer.MAX_VALUE;
        }
    }

    private Location getLocationByVillageName(String villageName) {
        switch (villageName) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> throw new IllegalArgumentException("Wrong location");
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        String sb = "City: " + city.getName() +
                System.lineSeparator() +
                "Nearest monster:" + findNearestMonster(city, monsters).getName() +
                System.lineSeparator() +
                "Killing time: " + getKillTime() +
                System.lineSeparator() +
                "Journey distance: " + getJourneyDistance();
        System.out.println(sb);
    }
}
