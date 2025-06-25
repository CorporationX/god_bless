package school.faang.normgame;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "ThreeLittlePigs")
public class ThreeLittlePigs {

    public static void main(String[] args) throws InterruptedException {
        var pigThreads = List.of(
                new Pig1Thread(),
                new Pig2Thread(),
                new Pig3Thread()
        );
        for (var pigThread : pigThreads) {
            pigThread.start();
        }
        for (var pigThread : pigThreads) {
            pigThread.join();
        }
        log.info("Игра завершена!");
    }
}
