package school.faang.miceverynice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static school.faang.ConcurrentUtils.tryLockAndDo;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
@Slf4j(topic = "Room")
@RequiredArgsConstructor
public class Room {

    private final Lock lock = new ReentrantLock();
    private final String name;
    private final List<Food> foods;

    public Food retrieveFood() {
        return tryLockAndDo(lock, () -> {
            var removed = foods.remove(0);
            log.info("В комнате {} нашли {}", name, removed);
            return removed;
        });
    }

    public boolean hasFood() {
        return tryLockAndDo(lock, () -> !foods.isEmpty());
    }
}
