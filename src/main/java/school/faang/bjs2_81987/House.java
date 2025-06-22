package school.faang.bjs2_81987;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class House {
    private List<RoleOfHouse> availableRoles;

    public synchronized RoleOfHouse assignRole() {
        if (availableRoles.isEmpty()) {
            log.info("Нет свободных ролей");
            return RoleOfHouse.DEFAULT;
        }

        RoleOfHouse role = availableRoles.remove(0);
        log.info("Выдана роль {}", role);
        return role;
    }

    public synchronized void releaseRole(RoleOfHouse role) {
        availableRoles.add(role);
        log.info("Возвращена роль {}", role);
    }
}
