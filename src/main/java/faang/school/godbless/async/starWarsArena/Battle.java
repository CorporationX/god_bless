package faang.school.godbless.async.starWarsArena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public static final Random RANDOMIZER = new Random();
    public static final ExecutorService FIGHTING_EXECUTOR = Executors.newFixedThreadPool(2);

    public Future<Droid> fight(Droid redDroid, Droid blueDroid) {

        return FIGHTING_EXECUTOR.submit(() -> {

            int redDroidAttack = RANDOMIZER.nextInt(0, 20) + redDroid.attack();
            int blueDroidAttack = RANDOMIZER.nextInt(0, 20) + blueDroid.attack();

            int redDroidDefenceAfterFight = redDroid.defence() - blueDroidAttack;
            int blueDroidDefenceAfterFight = blueDroid.defence() - redDroidAttack;

            return redDroidDefenceAfterFight > blueDroidDefenceAfterFight ? redDroid : blueDroid;
        });
    }

    public void endFights() {
        FIGHTING_EXECUTOR.shutdown();
    }
}
