package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city_worker;

import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.City;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.Location;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.monsters.Monster;

import java.util.List;
import java.util.Map;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;
    private final Map<String, GetLocation> locationMonster = Map.of(
            "Velen", () -> new Location(10, 20), "Toussaint", () -> new Location(40, 50),
            "White Orchard", () -> new Location(100, 10), "Skellige", () -> new Location(80, 120)
    );
//            "Velen", new Location(10, 20), "Toussaint", new Location(40, 50),
//            "White Orchard", new Location(100, 10), "Skellinge", new Location(80, 120)
//    );

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        System.out.printf("Monster %s at a distance %s \n", monster);
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        int xCity = city.getLocation().getX();
        int yCity = city.getLocation().getY();
        for (Monster monster : monsters) {
            if ()
        }
    }

    private Location getLocationCoordinates(String location) {
        return locationMonster.get(location).getLok();
    }
}
