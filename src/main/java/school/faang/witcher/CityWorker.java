package school.faang.witcher;
import java.util.List;

public class CityWorker implements Runnable {
    private City cityLocation;
    private List<monster> monsterList;

    public CityWorker(City city, List<monster> monsters) {
        cityLocation = city;
        monsterList = monsters;
    }

    private double calcDistance(location loc1, location loc2) {
        int dx = loc1.X() - loc2.Y();
        int dy = loc1.X() - loc2.Y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void run() {
        double distanceToCity = calcDistance(new location(0, 0), cityLocation.getLocation());
        monster closestMonster = null;
        double minDist = 0;

        for (monster m : monsterList) {
            double dist = calcDistance(cityLocation.getLocation(), m.getlocation());
            if (dist < minDist) {
                minDist = dist;
                closestMonster = m;
            }
        }

        if (closestMonster != null) {
            double totalDistance = distanceToCity + minDist;
            System.out.println("Город: " + cityLocation.Name() + " | Монстр: " + closestMonster.getname() +
                    " | Общая дистанция: " + totalDistance);
        } else {
            System.out.println("Для города " + cityLocation.Name() + " не найдено монстров поблизости."); }
    }
}














