package faang.school.godbless.pave_the_way;

import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsterList;
    @Override
    public void run() {
        System.out.println("Nearest monster to city: " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("To kill all the monsters Geralt needs to walk " + getJourneyDistance() + " kilometers" );
        System.out.println(getKillTime() + " hours");
    }

    public Monster findNearestMonster() {
        Monster nearestMonster = null;
        int distanceForEquals = Integer.MAX_VALUE;
        Location location = city.getLocation();
        for(Monster monster : monsterList) {
            Location monsterLocation = monster.getLocationCoordinates(monster.getLocation());
            int distance = (int)this.calculateDistance(location, monsterLocation);
            if(distance < distanceForEquals) {
                distanceForEquals = distance;
                nearestMonster = monster;
            }
        }
        System.out.println();
        return nearestMonster;
    }

    public long getKillTime() {
        return 10;
    }

    public long getJourneyDistance() {
        City start = new City("Kaer Morhen", new Location(180, 70));
        Location startCityLocation = start.getLocation();
        Monster firstMonster = monsterList.get(0);
        Location firstMonsterLocation = firstMonster.getLocationCoordinates(firstMonster.getLocation());
        int betweenMonsters = 0;
        int toFirstMonster = (int)calculateDistance(startCityLocation, firstMonsterLocation);
        for(int i = 0; i < monsterList.size() - 1; i++) {
            Monster currentMonster = monsterList.get(i);
            Location currentMonsterLocation = currentMonster.getLocationCoordinates(currentMonster.getLocation());
            Monster nextMonster = monsterList.get(i + 1);
            Location nextMonsterLocation = nextMonster.getLocationCoordinates(nextMonster.getLocation());
            int distance = (int)calculateDistance(currentMonsterLocation, nextMonsterLocation);
            betweenMonsters = betweenMonsters + distance;
        }
        return betweenMonsters + toFirstMonster;
    }

    public long calculateDistance(Location fromLocation, Location toLocation) {
        return (long)(Math.sqrt(Math.pow((toLocation.getX() - fromLocation.getX()), 2) + Math.pow((toLocation.getY() - fromLocation.getY()), 2)));
    }
}
