package Sprint_3.BJS2_36445;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Location cityLocation = new Location(30, 50);
        City city = new City("Novigrad", cityLocation);


        Monster monster1 = new Monster("Dragon", new Location(10, 20));
        Monster monster2 = new Monster("Griffin", new Location(35, 45));
        Monster monster3 = new Monster("Vampire", new Location(25, 30));

        List<Monster> monsters = new ArrayList<Monster>();
        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);

        CityWorker worker = new CityWorker(city, monsters);
        worker.run();
    }
}
