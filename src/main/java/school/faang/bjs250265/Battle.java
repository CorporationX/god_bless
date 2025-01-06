package school.faang.bjs250265;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot r1, Robot r2) {
        return executorService.submit(() -> {
            int power1 = r1.attackPower() + r1.defensePower();
            int power2 = r2.attackPower() + r2.defensePower();

            if (power1 > power2) {
                return r1;
            } else if (power1 < power2) {
                return r2;
            } else {
                return Math.random() > 0.5 ? r1 : r2;
            }
        });
    }
}