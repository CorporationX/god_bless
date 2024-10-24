package school.faang.task417.starwars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    public static Future<Robot> fight(Robot r1, Robot r2) {

        return service.submit(() -> {
            int firstTotalPower = r1.getAttackPower() + r1.getDefensePower();
            int secondTotalPower = r1.getAttackPower() + r1.getDefensePower();
            if (firstTotalPower >= secondTotalPower) {
                return r1;
            } else {
                return r2;
            }
        });

    }

    public static void shutdown() {
        service.shutdown();

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка, что то пошло не так");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
