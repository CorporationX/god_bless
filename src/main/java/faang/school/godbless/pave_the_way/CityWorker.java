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
            int distance = (int)(Math.sqrt(Math.pow((monsterLocation.getX() - location.getX()), 2) + Math.pow((monsterLocation.getY() - location.getY()), 2)));
            if(distance < distanceForEquals) {
                distanceForEquals = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return 10;
    }

    public long getJourneyDistance() {
        City start = new City("Kaer Morhen", new Location(180, 70));
        Location firstMonsterLocation = monsterList.get(0).getLocationCoordinates(monsterList.get(0).getLocation());
        int betweenMonsters = 0;
        int toFirstMonster = (int)(Math.sqrt(Math.pow((firstMonsterLocation.getX() - start.getLocation().getX()), 2) + Math.pow((firstMonsterLocation.getY() - start.getLocation().getY()), 2)));
        for(int i = 0; i < monsterList.size() - 1; i++) {
            Location currentMonsterLocation = monsterList.get(i).getLocationCoordinates(monsterList.get(i).getLocation());
            Location nextMonsterLocation = monsterList.get(i+1).getLocationCoordinates(monsterList.get(i+1).getLocation());
            int distance = (int)(Math.sqrt(Math.pow((currentMonsterLocation.getX() - nextMonsterLocation.getX()), 2) + Math.pow((currentMonsterLocation.getY() - nextMonsterLocation.getY()), 2)));
            betweenMonsters = betweenMonsters + distance;
        }
        return betweenMonsters + toFirstMonster;
    }
}
