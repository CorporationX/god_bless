package school.faang.sprint_3.task_43566;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int POOL_SIZE = 3;
    private static final int TIMEOUT = 5;
    private static final int GAMES_NUMBER = 20;
    private static final float EARN_POINT_CHANCE = 0.5f;
    private static final float LOST_LIFE_CHANCE = 0.7f;

    public static void main(String[] args) {
        Game game = new Game();
        addPlayers(game);

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        playGame(executor, game);
        executor.shutdown();

        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Общий счет игры: ");
                System.out.println("\tНабрано очков: " + game.getScore());
                System.out.println("\tПотеряно жизней: " + game.getLives());
            } else {
                System.out.println("Задачи не завершились за " + TIMEOUT + " минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static void addPlayers(Game game) {
        Player firstPlayer = new Player("Fin", 5);
        Player secondPlayer = new Player("Jake", 7);

        game.addPlayer(firstPlayer);
        game.addPlayer(secondPlayer);
    }

    private static void playGame(ExecutorService executor, Game game) {
        for (int i = 0; i < GAMES_NUMBER; i++) {
            boolean earnedPoints = Math.random() > EARN_POINT_CHANCE;
            boolean lostLife = Math.random() > LOST_LIFE_CHANCE;
            executor.execute(() -> game.update(earnedPoints, lostLife));
        }
    }
}
