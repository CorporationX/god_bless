package school.faang.kingtour;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "Trial")
@RequiredArgsConstructor
public class Trial implements Runnable {

    private static final int MAX_TRIAL_TIME = 1;

    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        Consumer<String> logTrial = action -> log.info("{} {} испытание '{}'", knightName, action, trialName);
        try {
            logTrial.accept("начал");
            Thread.sleep(MAX_TRIAL_TIME);
            logTrial.accept("закончил");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Испытание '{}' прервано", trialName, e.getCause());
        }
    }
}
