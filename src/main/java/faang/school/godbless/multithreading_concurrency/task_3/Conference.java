package faang.school.godbless.multithreading_concurrency.task_3;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class Conference {
    @Getter private static final int NUMBER_OF_MEMBERS = 10;
    @Getter private static final CyclicBarrier BARRIER = new CyclicBarrier(NUMBER_OF_MEMBERS);

    public void startStreaming() {
        log.info("Stream started!");
    }
}
