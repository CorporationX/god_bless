package src.faang.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Slf4j
@ToString
public class Trial implements Runnable {
    private static final int DELAY = 2;

    @Getter
    private final String knightName;
    @Getter
    private final String trialName;

    @SneakyThrows
    @Override
    public void run() {
        log.info("{} running trial {}", knightName, trialName);
        TimeUnit.SECONDS.sleep(DELAY);
        log.info("{} finished trial {}", knightName, trialName);
    }
}
