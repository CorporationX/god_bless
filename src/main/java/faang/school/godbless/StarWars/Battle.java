package faang.school.godbless.StarWars;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.*;


public class Battle {
    private static final int COUNT_THREAD  = 3;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

    public Future<Robot> fight(Robot bot1, Robot bot2) {
        return executorService.submit(() -> {
            try {
                return fighting(bot1, bot2).get();
            } catch (InterruptedException | ExecutionException e) {
                // Обработка исключений, если нужно
                throw new RuntimeException("Error occurred during battle execution", e);
            }
        });
    }

    public static Future<Robot> fighting(Robot robot1, Robot robot2) {
        int r1 = robot1.getAttackPower() - robot2.getDefensePower();
        int r2 = robot2.getAttackPower() - robot1.getDefensePower();

        if (r1 > r2){
            return CompletableFuture.completedFuture(robot1);
        } else if (r1 < r2){
            return CompletableFuture.completedFuture(robot2);
        } else {
            throw new IllegalArgumentException("Ничья либо некорректно введенные данные");
        }
    }
}