package school.faang.superheroes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    private static final int MAXIMUM_SKILL = 100;

    public static void main(String[] args) {
        SuperheroBattle superheroBattle = new SuperheroBattle();
        Random random = new Random();

        List<String> names = List.of("Iron Man", "Captain America", "Thor", "Hulk",
                "Spider-Man", "Vision", "Ultron", "Thanos", "Ant-Man");

        List<Superhero> superheroes = new ArrayList<>();
        for (String name : names) {
            int strength = random.nextInt(MAXIMUM_SKILL);
            int agility = random.nextInt(MAXIMUM_SKILL);
            superheroes.add(new Superhero(name, strength, agility));
        }

        List<Pair<Superhero, Superhero>> superheroPairs = superheroBattle.toPairs(superheroes);

        List<Future<Superhero>> winnersFutures = superheroBattle.runCompetitions(superheroPairs);

        try {
            Superhero winner = winnersFutures.get(0).get();
            log.info("Победитель финального боя: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        }

        superheroBattle.shutdown();
    }
}