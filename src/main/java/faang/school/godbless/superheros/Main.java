package faang.school.godbless.superheros;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();

        List<Superhero> remainingSuperheroList = new ArrayList<>(getSuperheroList());
        List<Pair<Superhero, Superhero>> superheroFightingPairList = superheroBattle.constructPairs(remainingSuperheroList);

        while (!superheroFightingPairList.isEmpty()) {
            List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroFightingPairList);

            superheroBattle.processSurvivedSuperheros(winnersFutures, remainingSuperheroList);

            superheroFightingPairList = superheroBattle.constructPairs(remainingSuperheroList);
        }

        log.info("Absolute winner: " + remainingSuperheroList.get(0));

        superheroBattle.endBattles();
    }

    private static List<Superhero> getSuperheroList() {
        return List.of(
                new Superhero("Iron Man", 9, 6),
                new Superhero("Captain America", 8, 8),
                new Superhero("Thor", 10, 7),
                new Superhero("Hulk", 10, 4),
                new Superhero("Loki", 20, 5),
                new Superhero("Archer", 10, 7),
                new Superhero("Panterra", 10, 13),
                new Superhero("Strange", 10, 13),
                new Superhero("Drax", 4, 10)
        );
    }
}
