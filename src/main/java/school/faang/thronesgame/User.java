package school.faang.thronesgame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static school.faang.thronesgame.UserRole.NO_ROLE;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
@Getter
@RequiredArgsConstructor
public class User {

    private final String name;
    private final Object lock = new Object();
    private UserRole assignedRole = NO_ROLE;

    public void joinHouse(House house) {
        synchronized (lock) {
            while (assignedRole.equals(NO_ROLE)) {
                assignedRole = house.assignRole();
                if (!assignedRole.equals(NO_ROLE)) {
                    break;
                }
                log.info("Пользователю {} не удалось получить роль", name);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("User | Поток {} прерван", Thread.currentThread().getName(), e.getCause());
                }
            }
            log.info("Пользователь {} получил роль {}", name, assignedRole);
            lock.notify();
        }
    }

    public void leaveHouse(House house) {
        synchronized (lock) {
            house.releaseRole(assignedRole);
            log.info("Пользователь {} вернул роль {}", name, assignedRole);
            assignedRole = NO_ROLE;
            lock.notify();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
