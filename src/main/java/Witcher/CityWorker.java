package Witcher;

import java.util.List;

public class CityWorker implements Runnable {
    private final City currentCity;
    private final City heraldCity = new City("Novigrad", new Location(0, 60), 180);
    List<Monster> monsters = List.of(
            new Monster("Griffin", "Velen"),
            new Monster("Basilisk", "Toussaint"),
            new Monster("Cockatrice", "White Orchard"),
            new Monster("Chort", "Skellige"));


    List<City> cities = List.of(
            new City("Novigrad", new Location(0, 60), 180),
            new City("Oxenfurt", new Location(60, 0), 70),
            new City("Vizima", new Location(120, 50), 30),
            new City("Kaer Morhen", new Location(180, 70), 0));

    public CityWorker(City currentCity) {
        this.currentCity = currentCity;
    }

    //Найти расстояние от города до близжайшего монстра
    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters == null || monsters.isEmpty()) {
            throw new NullPointerException("Монстров нет(");
        }

        Monster nearestMonster = new Monster();
        double minDistance = Double.MAX_VALUE;
        double tempDistance;
        //Пройтись по всем монстрам
        for (Monster monster : monsters) {
            //Найти координаты
            Location monsterCoordinates = monster.getLocationCoordinates();
            Location cityCoordinates = city.getLocation();
            //Высчитать расстояние
            tempDistance = getJourneyDistance(cityCoordinates, monsterCoordinates);
            // Если найденое расстояние меньше minDistance - записываем
            if (minDistance > tempDistance) {
                minDistance = tempDistance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (long) (Math.random() * 10000);
    }

    public long getJourneyDistance(Location startLocation, Location finalLocation) {
        //Найти расстояние между двумя точками по теореме Пифагора
        //Высчитать стороны "треугольника", гипотенуза которого проходит от начальной до конечной точки
        int x = Math.abs(startLocation.getX() - finalLocation.getX());
        int y = Math.abs(startLocation.getY() - finalLocation.getY());
        //Найти гипотенузу/искомое расстояние
        return (long) Math.hypot(x, y);
    }


    @Override
    public void run() {
        System.out.println("Близжайший монстр от " + currentCity.getName() + " - "
                + findNearestMonster(currentCity, monsters).getName());
        System.out.println("Потребуется времени - " + getKillTime() + " секунд");
        System.out.println("Расстояние от Геральда до " + currentCity.getName() + " "
                + getJourneyDistance(heraldCity.getLocation(), currentCity.getLocation()));
        for (City city : cities) {
            System.out.println("Расстояние от " + currentCity.getName() + " до " +
                    city.getName() + " " + getJourneyDistance(currentCity.getLocation(), city.getLocation()));
        }
    }
}
