package school.faang.ironthroneatanycost;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class User {
    @NonNull
    private final String name;
    private Role assignedRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info("{} выбрал роль: {}",
                    name, assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info("{}  покидает дом и освобождает роль: {}",
                        name, assignedRole);
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
