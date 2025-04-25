package school.faang.bjs2_73342;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class User {
    private final String name;
    private Role assignedRole;

    public void joinHouse(House house) {
        assignedRole = house.assignRole(this);
    }

    public void leaveHouse(House house) {
        if (this.assignedRole == null) {
            return;
        }

        if (!house.isUserAssigned(this)) {
            log.warn("{} trying to free up a role in someone else's house", name);
            return;
        }

        house.releaseRole(this);
        assignedRole = null;
    }
}
