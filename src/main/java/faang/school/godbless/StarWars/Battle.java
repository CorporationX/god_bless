package faang.school.godbless.StarWars;
import java.util.concurrent.*;

public class Battle {
    private static final int COUNT_THREAD = 3;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executorService.submit(() -> fighting(robot1, robot2));
    }

    public static Robot fighting(Robot robot1, Robot robot2) {
        int r1 = robot1.getAttackPower() - robot2.getDefensePower();
        int r2 = robot2.getAttackPower() - robot1.getDefensePower();
        if (r1 > r2){
            return robot1;
        } else if (r2 > r1){
            return robot2;
        } else {
            throw new IllegalArgumentException("Ничья либо некорректные данные");
        }
    }
}