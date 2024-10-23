package school.faang.task417.starwars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static Future<Robot> fight(Robot r1, Robot r2) {
        ExecutorService service = Executors.newSingleThreadExecutor();
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
}
