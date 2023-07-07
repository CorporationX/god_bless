package faang.school.godbless.starwars;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    private final ExecutorService executorService;
    private final Random random;

    public Battle() {
        random = new Random();
        executorService = Executors.newSingleThreadExecutor();
    }

    Future<Robot> fight(Robot r1, Robot r2) {
        Future<Robot> submit = executorService.submit(() -> {
            Robot attk1 = random.nextBoolean() ? r1 : r2;
            Robot attk2 = (attk1 == r1) ? r2 : r1;
            log.debug("Attacks first {}", attk1);

            long startTime = System.currentTimeMillis();
            long timeoutMillis = 5000;
            while (attk1.getAttackPower() > 0 && attk2.getDefensePower() > 0) {
                attack(attk1, attk2);

                Robot tmp = attk1;
                attk1 = attk2;
                attk2 = tmp;
                log.debug("Now the {} is attacking the {}", attk1, attk2);

                if (System.currentTimeMillis() - startTime > timeoutMillis) {
                    break;
                }
            }

            return (attk1.getAttackPower() > 0) ? attk1 : attk2;
        });
        executorService.shutdown();

        return submit;
    }

    private void attack(Robot attk1, Robot attk2) {
        int damage = attk1.getAttackPower();
        attk2.setDefensePower(attk2.getDefensePower() - damage);
    }
}
