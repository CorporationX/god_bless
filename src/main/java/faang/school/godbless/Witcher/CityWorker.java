package faang.school.godbless.Witcher;

import java.util.List;

public class CityWorker implements Runnable{
    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster bufferMonster = null;
        double bufferDistance = city.getDistance();

        for (Monster monster : monsters) {
            double calculatedDistance = calculateDistance(city, monster);
            if (calculatedDistance < bufferDistance) {
                bufferDistance = calculatedDistance;
                bufferMonster = monster;
            }
        }

        return bufferDistance >= city.getDistance() ? null : bufferMonster; // если расстояние до монстра > расстояние до другого города, то монстр находится в другом городе, в этом городе такого монстра нет
    }

    public long getKillTime() {
        return 0;
    }

    public double calculateDistance(City city, Monster monster) {
        double x = Math.abs(city.getLocation().getX() - monster.getLocation().getX());
        double y = Math.abs(city.getLocation().getY() - monster.getLocation().getY());

        return Math.sqrt(x * x + y * y);
    }

    @Override
    public void run() {

    }
}
