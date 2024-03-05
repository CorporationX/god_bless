package faang.school.godbless.starwarsarena3241;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Arena {
    static Robot[] firstPairFighting = new Robot[2];
    static Robot[] secondPairFighting = new Robot[2];
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        createFightingPairs();
        Battle firstFight = new Battle();
        Battle secondFight = new Battle();
        Battle finalFight = new Battle();
        
        Future<Robot> firstFightWinner = firstFight.fight(firstPairFighting[0], firstPairFighting[1], EXECUTOR);
        Future<Robot> secondFightWinner = secondFight.fight(secondPairFighting[0], secondPairFighting[1], EXECUTOR);
        threadSleep();
        System.out.printf("""
                First two fights result:
                %s won first fight
                %s won second fight.
                Now the final battle begins...
                """, firstFightWinner.get().getName(), secondFightWinner.get().getName());

        Future<Robot> finalFightWinner = finalFight.fight(firstFightWinner.get(), secondFightWinner.get(), EXECUTOR);
        threadSleep();
        System.out.println("And the only one alive and well (not really) is " + finalFightWinner.get().getName());
        EXECUTOR.shutdown();
    }

    private static void createFightingPairs() {
        Robot c3p0 = new Robot("C3P0", 247, 159);
        Robot r2d2 = new Robot("R2D2", 198, 210);
        Robot droid = new Robot("DROID", 298, 55);
        Robot tank = new Robot("TANK", 99, 329);
        firstPairFighting[0] = c3p0;
        firstPairFighting[1] = tank;
        secondPairFighting[0] = r2d2;
        secondPairFighting[1] = droid;
    }

    private static void threadSleep() {
        try {
            Thread.sleep(2500L);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
