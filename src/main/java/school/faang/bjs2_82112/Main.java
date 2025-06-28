package school.faang.bjs2_82112;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        BiConsumer<Integer, Integer> gamePlay = getGamePlay(game);

        List<Runnable> playersGamePlay = List.of(
                () -> gamePlay.accept(2, 2),
                () -> gamePlay.accept(5, 3),
                () -> gamePlay.accept(8, 6),
                () -> gamePlay.accept(3, 7)
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Runnable play : playersGamePlay) {
            executor.submit(play);
        }
        executor.shutdown();
    }

    private static BiConsumer<Integer, Integer> getGamePlay(Game game) {
        return (chanceGetScore, chanceLoseLive) -> {
            for (int i = 0; i <= 20; i++) {
                boolean isLoseLives = new Random().nextInt(0, 10) <= chanceLoseLive;
                boolean isGetScore = new Random().nextInt(0, 10) <= chanceGetScore;

                game.update(isGetScore, isLoseLives);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };
    }
}