package school.faang.witchergeralt;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final List<City> CITIES = List.of(
            new City("name", new Location(46, 568)),
            new City("name", new Location(626, 1236)),
            new City("name", new Location(446, 65)),
            new City("name", new Location(843, 223)),
            new City("name", new Location(1294, 757))
    );
    private static final List<Monster> MONSTERS = List.of(
            new Monster("name", new Location(324, 235)),
            new Monster("name", new Location(647, 757)),
            new Monster("name", new Location(262, 234)),
            new Monster("name", new Location(945, 4)),
            new Monster("name", new Location(2356, 32)),
            new Monster("name", new Location(124, 897)),
            new Monster("name", new Location(6, 54)),
            new Monster("name", new Location(17, 437)),
            new Monster("name", new Location(588, 436)),
            new Monster("name", new Location(1644, 23))
    );
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(CITIES.size());

    public static void main(String[] args) {

    }
}
