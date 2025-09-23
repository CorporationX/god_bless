package school.faang.m3_1_parallelism.weasleyfamily;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Chore implements Runnable {
    public static final int TIMEOUT = 1000;
    private final String chore;

    @Override
    public void run() {
        try {
            Thread.currentThread().setName(chore);
            Thread.sleep(TIMEOUT);
            log.info("Выполнена задача");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
