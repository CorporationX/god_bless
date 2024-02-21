package faang.school.godbless.priscillasong2904;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster nearest = findNearestMonster(this.city, this.monsters);
        long timeToKill = getKillTime(nearest);
        System.out.printf("Nearest to %s is %s. You gonna spend %d minutes to kill it%n",
                this.city.getName(), nearest, timeToKill / 100);
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        long distance = Long.MAX_VALUE;
        Monster nearestMonster = new Monster("", "");
        String currentCityName = city.getName();
        for (Monster monster : monsters) {
            String monsterCityName = monster.getCityName();
            if (monsterCityName.equals(currentCityName)) {
                return monster;
            }

            long distanceToMonster = getJourneyDistance(city, monster.getLocation());
            if (distanceToMonster < distance) {
                nearestMonster = monster;
                distance = distanceToMonster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(Monster monster) {
        String monsterName = monster.getName();
        return switch (monsterName) {
            case "Wilkolak" -> 12000L;
            case "Alghoul" -> 6000L;
            case "Borowik" -> 15000L;
            case "Gryf" -> 20000L;
            default -> 0L;
        };
    }

    public long getJourneyDistance(City currentCity, Location monsterThere) {
        Location cityLocation = currentCity.getLocation();
        return (cityLocation.getCoordinateX() - monsterThere.getCoordinateX()) +
                (cityLocation.getCoordinateY() - monsterThere.getCoordinateY());
    }
}
