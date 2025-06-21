package school.faang.thronesgame;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static school.faang.thronesgame.UserRole.NO_ROLE;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
@RequiredArgsConstructor
public class House {

    private final List<UserRole> availableRoles;

    public synchronized UserRole assignRole() {
        if (!availableRoles.isEmpty()) {
            var role = availableRoles.remove(0);
            log.info("Выдана роль: {}", role);
            return role;
        }
        log.info("Нет доступных ролей");
        return NO_ROLE;
    }

    public synchronized void releaseRole(UserRole role) {
        availableRoles.add(role);
        log.info("Возвращена роль: {}", role);
    }

    public int getFreeSlotsNumber() {
        return availableRoles.size();
    }
}
