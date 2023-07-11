package faang.school.godbless.fourth.Superheroes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class SuperheroBattle {
    public List<Future<Superhero>> runCompetitions(List<Pair> pairForBattle) {
        var service = Executors.newFixedThreadPool(10);
        List<Future<Superhero>> battleWinners = new ArrayList<>();

        for (Pair pair : pairForBattle) {
            battleWinners.add(service.submit(() -> findWinner(pair)));
        }
        service.shutdown();

        return battleWinners;
    }

    public Superhero findWinner(Pair pair) {
        Superhero hero1 = pair.first();
        Superhero hero2 = pair.second();
        int hero1TotalPower = hero1.agility() + hero1.strength();
        int hero2TotalPower = hero2.agility() + hero2.strength();

        if (hero1TotalPower > hero2TotalPower) {
            return hero1;
        } else if (hero1TotalPower < hero2TotalPower) {
            return hero2;
        } else {
            int randomNum = ThreadLocalRandom.current().nextInt(2);
            if (randomNum == 0) {
                return hero1;
            } else {
                return hero2;
            }
        }
    }
}
