package multithreading_part2.star_wars;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
@Getter
public class Battle {
    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    public Future<Robot> figth(Robot robot1, Robot robot2) {
        Random random = new Random();
        Future<Robot> future = executorService.submit(() -> {
            System.out.println("Битва " + robot1.getName() + " с " + robot2.getName() + " начинается");
            while (robot1.getDefensePower() > 0 && robot2.getDefensePower() > 0) {
                int input = random.nextInt(0, 2);
                if (input == 0) {
                    robot1.attack(robot2);
                } else {
                    robot2.attack(robot1);
                }
            }
            if (robot1.getDefensePower() > 0) {
                return robot1;
            } else {
                return robot2;
            }
        });
        return future;
    }
}
