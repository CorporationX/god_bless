package school.faang.sprint1.task_50284;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private ExecutorService executor = Executors.newFixedThreadPool(10); // Пул потоков

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            // Логика битвы
            int power1 = robot1.getAttackPower() + robot1.getDefensePower();
            int power2 = robot2.getAttackPower() + robot2.getDefensePower();

            if (power1 > power2) {
                return robot1;
            } else if (power2 > power1) {
                return robot2;
            } else {
                // Если силы равны, выбираем случайного победителя
                return Math.random() > 0.5 ? robot1 : robot2;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}

