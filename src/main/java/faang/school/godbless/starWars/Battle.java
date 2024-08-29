package faang.school.godbless.starWars;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
public class Battle {
    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executorService.submit(() -> {
            while (robot1.getHealth() > 0 && robot2.getHealth() > 0) {
                System.out.println("Health: " + robot1.getHealth() + " / " + robot2.getHealth());
                robot1.attack(robot2);
                robot2.attack(robot1);
            }
            if (robot1.getHealth() <= 0) {
                return robot2;
            } else {
                return robot1;
            }
        });
    }
}
