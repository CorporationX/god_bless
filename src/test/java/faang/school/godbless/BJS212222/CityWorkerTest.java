package faang.school.godbless.BJS212222;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityWorkerTest {
    @Test
    void testFindNearestMonster() {
        City kaerMorhen = new City("Kaer Morhen", new Location(0, 0));
        City novigrad = new City("Novigrad", new Location(10, 10));
        List<Monster> monsters = List.of(
                new Monster("Ghoul", new Location(2, 2)),
                new Monster("Vampire", new Location(2, 3)),
                new Monster("Kikimora", new Location(5, 10)),
                new Monster("Striga", new Location(2, 0))
        );

        CityWorker cityWorker = new CityWorker(kaerMorhen, novigrad, monsters);

        Monster actual = cityWorker.findNearestMonster(kaerMorhen, monsters);
        Monster expected = monsters.get(2);

        assertEquals(expected, actual);
    }
}
