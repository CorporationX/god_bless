package school.faang.synchronized__notify.bjs2_90328;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {
    @Getter
    private final String name;
    private String assignedRole;
    private @NonNull House house;

    public void joinHouse() {
        assignedRole = house.assignRole();
        log.info("Пользователь - {}, взял роль {}", name, assignedRole);
    }

    public void leaveHouse() {
        if (assignedRole == null) {
            return;
        }
        log.info("Пользователь - {}, вернул роль {}", name, assignedRole);
        house.releaseRole(assignedRole);
        assignedRole = null;
    }
}