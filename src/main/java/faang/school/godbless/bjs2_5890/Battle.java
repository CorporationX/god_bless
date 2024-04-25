package faang.school.godbless.bjs2_5890;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {

    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    private static final int BATTLE_MIN_TIME = 2;
    private static final int BATTLE_MAX_TIME = 10;

    public static void main(String[] args) throws InterruptedException {

        Battle battle = new Battle();

        // Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot r2d3 = new Robot("R2-D3", 5, 7);
        Robot c3p2 = new Robot("C-3P2", 4, 8);
        Robot r2d4 = new Robot("R2-D4", 5, 7);
        Robot c3p3 = new Robot("C-3P3", 4, 8);

        // Запуск битв
        List<Future<Robot>> futureWinners = new ArrayList<>();
        futureWinners.add(battle.fight(r2d2, c3po));
        futureWinners.add(battle.fight(r2d3, c3p2));
        futureWinners.add(battle.fight(r2d4, c3p3));

        // Обработка результата
        try {
            while (!futureWinners.isEmpty()) {
                for (int i = 0; i < futureWinners.size(); i++) {
                    Future<Robot> currentBattle = futureWinners.get(i);
                    if (currentBattle.isDone()) {
                        log.info("Победитель битвы: {}", currentBattle.get().getName());
                        futureWinners.remove(currentBattle);
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            log.error(e.getMessage());
        } finally {
            executorService.shutdown();
        }
        while (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
        }
        log.info("All battles finished!");
    }

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return executorService.submit(() -> emulateBattle(firstRobot, secondRobot));
    }

    private Robot emulateBattle(Robot firstRobot, Robot secondRobot) {
        int randomWinnerIndex = new Random().nextInt(2);
        Robot winnerRobot = firstRobot;
        if (randomWinnerIndex == 1) {
            winnerRobot = secondRobot;
        }
        log.info("Battle between {} and {} start...", firstRobot.getName(), secondRobot.getName());
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(BATTLE_MIN_TIME, BATTLE_MAX_TIME + 1));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return winnerRobot;
    }

}
