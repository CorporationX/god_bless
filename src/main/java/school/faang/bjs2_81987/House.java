package school.faang.bjs2_81987;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class House {
    private List<RoleOfHouse> availableRoles;

    public synchronized RoleOfHouse tryAssignRole() {
        while (availableRoles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Ошибка при ожидании роли: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        RoleOfHouse role = availableRoles.remove(0);
        log.info("Выдана роль {}", role);
        return role;
    }

    public synchronized void releaseRole(RoleOfHouse role) {
        availableRoles.add(role);
        log.info("Возвращена роль {}", role);
        notifyAll();
    }
}
