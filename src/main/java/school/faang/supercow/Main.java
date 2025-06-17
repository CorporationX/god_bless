package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
@Slf4j
public class Main {

    private static final int MAX_PLAYERS = 5;
    private static final int CURRENT_PLAYERS = 10;

    public static void main(String[] args) {
        var boss = new Boss(MAX_PLAYERS);
        var threads = new ArrayList<Thread>();
        for (var i = 0; i < CURRENT_PLAYERS; i++) {
            final int j = i;
            var thread = new Thread(() -> new Player("Player %d".formatted(j)).doBattle(boss));
            threads.add(thread);
            thread.start();
        }
        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток {} прерван", Thread.currentThread().getName(), e.getCause());
            }
        }
    }
}
