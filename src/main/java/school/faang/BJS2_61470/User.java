package school.faang.BJS2_61470;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public synchronized void joinHouse(@NonNull House house) {
        String result = house.assignRole();
        if (result != null) {
            assignedRole = result;
            this.house = house;
            log.info(ConstAndMessages.USER_JOINED_HOUSE, name, house.getName(), assignedRole);
        } else {
            log.error(ConstAndMessages.ERROR_JOINED_ROLE, house.getName());
        }
    }

    public synchronized void leaveHouse() {
        if (assignedRole != null && house != null) {
            house.releaseRole(assignedRole);
            log.info(ConstAndMessages.USER_LEFT_HOUSE, name, house.getName(), assignedRole);
            assignedRole = null;
            this.house = null;
        }
    }
}
