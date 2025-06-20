package school.faang.module1.bjs2_82002;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class UserRunner implements Runnable {

    private final User user;
    private final House house;
    private static final int TIMEOUT = 3000;

    @Override
    public void run() {
        user.joinHouse(house);
        try {
            Thread.sleep(TIMEOUT);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Поток был прерван", e);
            return;
        }
        user.leaveHouse();
    }
}