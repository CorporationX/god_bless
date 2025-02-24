package school.faang.sprint3.task_63366;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
@Getter
public class User {
    public static final int TIME_ON_DUTY = 1000;
    private static final AtomicInteger add = new AtomicInteger();
    private static final AtomicInteger remove = new AtomicInteger();

    private final String name;
    @Setter
    private Role role;

    public void joinHouse(House house) {
        house.assignRole(this);
        add.incrementAndGet();
        try {
            Thread.sleep(TIME_ON_DUTY);
        } catch (InterruptedException e) {
            log.error("Принудительно закрываем спящий поток", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        leaveHouse(house);

    }

    private void leaveHouse(House house) {
        house.releaseRole(this);
        remove.incrementAndGet();
    }

    public static void printResult() {
        log.info("Добавили {} юзеров, удалили {}", add.get(), remove.get());
    }
}
