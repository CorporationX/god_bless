package school.faang.thronesgame;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

import static school.faang.thronesgame.UserRole.NO_ROLE;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
public class House {

    private final Deque<UserRole> availableRoles;

    public House(List<UserRole> availableRoles) {
        this.availableRoles = new ConcurrentLinkedDeque<>(availableRoles);
    }

    public UserRole assignRole() {
        synchronized (availableRoles) {
            if (!availableRoles.isEmpty()) {
                var role = availableRoles.poll();
                log.info("Выдана роль: {}", role);
                return role;
            }
            log.info("Нет доступных ролей");
            return NO_ROLE;
        }
    }

    public void releaseRole(UserRole role) {
        synchronized (availableRoles) {
            availableRoles.offer(role);
            log.info("Возвращена роль: {}", role);
        }
    }

    public int getFreeSlotsNumber() {
        return availableRoles.size();
    }
}
