//package Witcher.test;
//
//import Witcher.City;
//import Witcher.CityWorker;
//import Witcher.Location;
//import Witcher.Monster;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//class CityWorkerTest {
//    @BeforeEach
//    public void setUp(){
//        Monster monster1 = new Monster("Bob", "Velen");
//        Monster monster2 = new Monster("Rob", "Toussaint");
//        List<City> cities = new ArrayList<>();
//        City novigard = new City("Novigrad", new Location(0, 60), 180);
//        City oxenfurt = new City("Oxenfurt", new Location(60, 0), 70);
//        City vizima = new City("Vizima", new Location(120, 50), 30);
//        City kaerMorhen = new City("Kaer Morhen", new Location(180, 70), 0);
//    }
//
//    @Test
//    void shouldFindNearestMonster() {
//        City vizima = new City("Vizima", new Location(120, 50), 30);
//        List<Monster> monsters = new ArrayList<>();
//        monsters.add(new Monster("Bob", "Velen"));
//        monsters.add( new Monster("Rob", "Toussaint"));
//
//        assertEquals(monsters.get(1), new CityWorker().findNearestMonster(vizima, monsters));
//    }
//
//    @Test
//    void findDistance() {
//    }
//}