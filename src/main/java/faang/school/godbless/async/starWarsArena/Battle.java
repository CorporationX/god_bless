package faang.school.godbless.async.starWarsArena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Droid> fight(Droid redDroid, Droid blueDroid) {
        ExecutorService fightingExecutor = Executors.newFixedThreadPool(2);

        Random randomizer = new Random();

        var winner = fightingExecutor.submit(() -> {

            int redDroidAttack = randomizer.nextInt(0, 20) + redDroid.attack();
            int blueDroidAttack = randomizer.nextInt(0, 20) + blueDroid.attack();

            int redDroidDefenceAfterFight = redDroid.defence() - blueDroidAttack;
            int blueDroidDefenceAfterFight = blueDroid.defence() - redDroidAttack;

            if(redDroidDefenceAfterFight > blueDroidDefenceAfterFight) {
                return redDroid;
            }

            return blueDroid;
        }  );

        fightingExecutor.shutdown();

        return winner;
    }
}
