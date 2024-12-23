package school.faang.task50582;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class SuperheroBattle {
    public void runCompetitions(List<Pair<Superhero>> pairs) {
        CompletableFuture
                .allOf(pairs.stream()
                        .parallel()
                        .map(pair -> CompletableFuture
                                .supplyAsync(() -> battle(pair))
                                .thenAccept(hero -> log.info("В паре {} выявлен победитель: {}", pair, hero.name())))
                        .toArray(CompletableFuture[]::new))
                .join();
    }

    private Superhero battle(Pair<Superhero> pair) {
        Superhero hero1 = pair.first();
        Superhero hero2 = pair.second();

        int hero1Power = hero1.agility() + hero1.strength();
        int hero2Power = hero2.agility() + hero2.strength();

        if (hero1Power > hero2Power) {
            return hero1;
        } else if (hero2Power > hero1Power) {
            return hero2;
        }

        return Math.random() > 0.5 ? hero1 : hero2;
    }
}
