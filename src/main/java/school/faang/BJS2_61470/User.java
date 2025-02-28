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

    public void joinHouse(@NonNull House house) {
        assignedRole = house.assignRole();
        this.house = house;
        log.info(ConstAndMessages.USER_JOINED_HOUSE, name, house.getName(), assignedRole);
    }

    public void leaveHouse() {
        if (assignedRole != null && house != null) {
            house.releaseRole(assignedRole);
            log.info(ConstAndMessages.USER_LEFT_HOUSE, name, house.getName(), assignedRole);
            assignedRole = null;
            this.house = null;
        }
    }
}
