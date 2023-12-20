package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockaitrice", "With Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime- startTime) + "ms");
    }
}

@Getter
@AllArgsConstructor
class Monster {
    private String name;
    private String location;

    public Location getLocationCoordinates() {
        switch (location) {
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
            default -> {
                return new Location(0, 0);
            }
        }
    }
}

@Getter
class City {
    private String city;
    private Location location;
    private int distance;

    public City(String city, Location location, int distance) {
        this.city = city;
        this.location = location;
        this.distance = distance;
    }
}

@Getter
class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

@Getter
@AllArgsConstructor
class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster() {
        Location cityCoordinate = city.getLocation();
        int distMax = Integer.MAX_VALUE;
        Monster monstrik = null;
        for (Monster monster : monsters) {
            Location monstrishe = monster.getLocationCoordinates();
            int distanceX = Math.abs(cityCoordinate.getX() - monstrishe.getX());
            int distanceY = Math.abs(cityCoordinate.getY() - monstrishe.getY());
            int sumDistance = distanceX + distanceY;
            if (sumDistance < distMax) {
                distMax = sumDistance;
                monstrik = monster;
            }
        }
        return monstrik;
    }

    public long getKillTime() {
        long time = new Random().nextLong(20) + 1;
        return time;
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }


    @Override
    public void run() {
        System.out.println(" Ближайший монстр к городу " + city.getCity() + " монстр " + findNearestMonster().getName());
        System.out.println(" Время на убийство: " + getKillTime());
        System.out.println(" Расстояние: " + getJourneyDistance());
    }
}

/*
3. Создать класс CityWorker, который будет реализовывать интерфейс Runnable и содержать логику обработки одного города:
поиск ближайшего монстра (public Monster findNearestMonster(City city, List<Monster> monsters)). Чтобы найти ближайшего монстра,
можно посчитать разницу между положением города и положением каждого монстра;
расчёт времени на убийство монстра (public long getKillTime()). Пока Геральт убивает монстра, мы ждем;
дальность путешествия (public long getJourneyDistance()). Геральт находится там, где дистанция между ним и городом равна 0.
По умолчанию Геральт находится в Каэр Морхене. Чтобы определить, как долго Геральту идти, нужно посчитать разницу дистанций.
Если вам кажется, что здесь можно добавить какие-то дополнительные параметры — тоже можете добавить. Это время проявить творчество!
4. Создать класс Witcher, который будет содержать метод main и служить точкой входа в программу.
В методе main нужно создать список городов и монстров (примеры приведены ниже),
создать ExecutorService с фиксированным числом потоков и запустить работу потоков на обработку каждого города в отдельности.
После завершения работы всех потоков нужно вычислить общее время, затраченное на выполнение программы.
5. В методе main можно изменять параметр NUM_THREADS и количество городов и монстров в списках, чтобы сравнить время выполнения
программы в однопоточном и многопоточном режимах. Это главное условие задачи. Посмотрите, будет ли программа
выполняться быстрее в один поток, чем в несколько.

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
1. Создать класс Monster, который будет содержать информацию о монстрах: имя и местоположение. Добавить конструктор и геттеры.
2. Создать класс City, который будет содержать информацию о городах: имя, местоположение (класс Location c полями-координатами x, y)
и расстояние от местоположения ведьмака до каждого города. По умолчанию Геральт находится в Каэр Морхене. Конструктор и геттеры.

 */
