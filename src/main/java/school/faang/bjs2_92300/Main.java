package school.faang.bjs2_92300;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Main {
    private static final int ACTION_AMOUNT = 3;

    public static void main(String[] args) {
        log.info("Программа запущена");
        Game game = new Game();
        List<Player> players = List.of(
                new Player("Alex"),
                new Player("Mike"),
                new Player("Steve"),
                new Player("John"),
                new Player("Mark"),
                new Player("Peter")
        );
        Thread[] threads = new Thread[players.size()];
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                boolean isScoreUp;
                boolean isLiveLost;
                while (players.get(finalI).getLives() != 0) {
                    isScoreUp = Math.random() >= 0.5;
                    isLiveLost = Math.random() < 0.5;
                    game.update(isScoreUp, isLiveLost, players.get(finalI));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage());
                    }
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        log.info("Общий счет в игре равен {}", game.getScore());
    }
}
