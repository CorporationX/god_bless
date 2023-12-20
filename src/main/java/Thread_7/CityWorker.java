package Thread_7;

import java.util.List;

public class CityWorker implements Runnable {

    private City cityCompute;
    private List<Monster> monsterListCompute;

    public CityWorker(City cityCompute, List<Monster> monsterListCompute) {
        this.cityCompute = cityCompute;
        this.monsterListCompute = monsterListCompute;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters.size() > 0) {
            Monster nearerMonster = monsters.get(0);
            int nearerTrack = getJourneyDistance(city, monsters.get(0));
            for (int i = 1; i < monsters.size(); i++) {
                if (getJourneyDistance(city, monsters.get(i)) < nearerTrack) {
                    nearerTrack = getJourneyDistance(city, monsters.get(i));
                    nearerMonster = monsters.get(i);
                }
            }
            return nearerMonster;
        } else
            throw new IllegalArgumentException("World don't need with Witchers. All monsters dead!");
    }

    public long getKillTime() {
        return (long) (Math.random() * 100);
    }

    public int getJourneyDistance(City city, Monster monster) {
        return Math.abs((monster.getLocation().isX() - city.getLocation().isX())) + Math.abs((monster.getLocation().isY() - city.getLocation().isY()));
    }

    public void run() {
        System.out.println("Kill nearest monster by " + cityCompute.getName() + " need " +
                (getJourneyDistance(cityCompute, findNearestMonster(cityCompute, monsterListCompute)) + getKillTime()) + " hours");
    }
}
