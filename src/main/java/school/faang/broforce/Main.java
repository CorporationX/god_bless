package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static school.faang.broforce.EventType.LIVES_DOWN;
import static school.faang.broforce.EventType.SCORES_UP;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        var game = new Game();
        var threads = new ArrayList<Thread>();
        for (var i = 0; i < 100; i++) {
            var thread = new Thread(() -> game.update(SCORES_UP));
            threads.add(thread);
            thread.start();
        }
        for (var i = 0; i < 51; i++) {
            var thread = new Thread(() -> game.update(LIVES_DOWN));
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
        log.info("Очки опыта: {}; Потеряно жизней: {}", game.getScore(), game.getLives());
    }
}
