package StarWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot r1, Robot r2) {
        if (r1 == null || r2 == null) {
            throw new IllegalArgumentException("r1 or r2 is null");
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Битва началась!");
        return executorService.submit(() -> {
            while (r1.getDefensePower() >= 0 && r2.getDefensePower() >= 0) {
                r1.setDefensePower(r1.getDefensePower() - r2.getAttackPower());
                r2.setDefensePower(r2.getDefensePower() - r1.getAttackPower());
            }

            Thread.sleep(5000L);

            executorService.shutdown();
            System.out.println("Битва закончилась!");
            if (r1.getDefensePower() > r2.getDefensePower()) {
                return r1;
            } else {
                return r2;
            }
        });
    }
}
