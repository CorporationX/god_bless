package Witcher;

import java.util.List;

public class CityWorker implements Runnable{

    //Найти расстояние от города до близжайшего монстра
    public Monster findNearestMonster(City city, List<Monster> monsters){
        if (monsters == null || monsters.isEmpty()){
            throw new NullPointerException ("Монстров нет(");
        }

        Monster nearestMonster = new Monster();
        double minDistance = Double.MAX_VALUE;
        double tempDistance;
        //Пройтись по всем монстрам
        for (Monster monster : monsters){
            //Найти координаты
            Location monsterCoordinates = monster.getLocationCoordinates();
            Location cityCoordinates = city.getLocation();
            //Высчитать расстояние
            tempDistance = findDistance(cityCoordinates, monsterCoordinates);
            // Если найденое расстояние меньше minDistance - записываем
            if (minDistance > tempDistance){
                minDistance = tempDistance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(){
        return (long) (Math.random()*10000);
    }

    public long getJourneyDistance(){

    }

    public double findDistance(Location startLocation, Location finalLocation){
        //Найти расстояние между двумя точками по теореме Пифагора
        //Высчитать стороны "треугольника", гипотенуза которого проходит от начальной до конечной точки
        int x = Math.abs(startLocation.getX() - finalLocation.getX());
        int y = Math.abs(startLocation.getY() - finalLocation.getY());
        //Найти гипотенузу/искомое расстояние
        return Math.hypot(x, y);
    }

    @Override
    public void run() {

    }
}
