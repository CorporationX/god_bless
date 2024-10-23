package bjs2_38333;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private final ExecutorService service;

    public Battle() {
        service = Executors.newFixedThreadPool(3);
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return service.submit(() -> {
            int total1 = robot1.getAttackPower() + robot1.getDefensePower();
            int total2 = robot2.getAttackPower() + robot2.getDefensePower();
            TimeUnit.MILLISECONDS.sleep(total1 + total2);

            if (total1 > total2) return robot1;
            return robot2;
        });
    }

    public void shutdown() {
        service.shutdown();
    }
}
