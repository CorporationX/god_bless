package school.faang.testThread001;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TestThread001 implements Runnable {

    private final String taskName;

    @Override
    public void run() {
        log.info("AAAAAAAAAAAAAAAAA Hello World. taskName is: {}, thread name is: {}",
            taskName, Thread.currentThread().getName());
    }
}
