package school.faang.sprint_3.task_48370;

import java.util.List;

public class Data {

    public static List<City> getCities() {
        return List.of(
                new City("Novigrad", new Location(100, 600)),
                new City("Oxenfurt", new Location(600, 0)),
                new City("Vizima", new Location(1200, 500)),
                new City("Kaer Morhen", new Location(1800, 700)),
                new City("Skellige", new Location(2000, -1000)),
                new City("Kaedwen", new Location(-1500, 2000)),
                new City("Temeria", new Location(500, 300)),
                new City("Redania", new Location(-300, -1500)),
                new City("Nilfgaard", new Location(3000, 1000)),
                new City("Mahakam", new Location(-1000, -500)),
                new City("Novigrad", new Location(1200, 1500)),
                new City("Oxenfurt", new Location(1700, 1200)),
                new City("Vizima", new Location(2400, 800)),
                new City("Kaer Morhen", new Location(3500, 1000)),
                new City("Skellige", new Location(-2500, 1800)),
                new City("Kaedwen", new Location(1000, -300)),
                new City("Temeria", new Location(2500, 700)),
                new City("Redania", new Location(300, 1300)),
                new City("Nilfgaard", new Location(1700, -1500))
        );
    }

    public static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", new Location(100, 150)),
                new Monster("Basilisk", new Location(2350, 1210)),
                new Monster("Cockatrice", new Location(-1240, 360)),
                new Monster("Chort", new Location(3740, -2370)),
                new Monster("Wraith", new Location(1300, -1100)),
                new Monster("Leshen", new Location(-900, 800)),
                new Monster("Vampire", new Location(2500, -200)),
                new Monster("Drowner", new Location(500, -800)),
                new Monster("Golem", new Location(0, 2200)),
                new Monster("Manticore", new Location(800, -1800)),
                new Monster("Griffin", new Location(300, 1500)),
                new Monster("Basilisk", new Location(1100, -800)),
                new Monster("Cockatrice", new Location(-700, 100)),
                new Monster("Chort", new Location(2100, -1200)),
                new Monster("Wraith", new Location(1500, 2000)),
                new Monster("Leshen", new Location(3200, 1500)),
                new Monster("Vampire", new Location(-1200, 700)),
                new Monster("Drowner", new Location(2200, -500)),
                new Monster("Golem", new Location(-400, 300))
        );
    }

}
