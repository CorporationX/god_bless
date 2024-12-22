package school.faang.sprint3.task_49248;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@RequiredArgsConstructor
@Slf4j
public class UserAction implements Runnable {

    private final CountDownLatch latch;
    private final Runnable action;

    @Override
    public void run() {
        try {
            action.run();
            latch.countDown();
        } catch (UnsupportedOperationException e) {
            log.error(e.toString());
        }
    }
}
