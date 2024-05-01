package faang.school.godbless.starWarsArena;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(new Callable<Robot>() {
            @Override
            public Robot call() throws Exception {
                if (robot1.getAttackPower() > robot2.getAttackPower()) {
                    return robot1;
                } else {
                    return robot2;
                }
            }
        });
    }
}
