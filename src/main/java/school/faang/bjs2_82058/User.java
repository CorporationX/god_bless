package school.faang.bjs2_82058;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        this.house = house;
        this.assignedRole = house.assignRole(name);
        if (assignedRole == null) {
            log.warn("{} could not join the house — no roles available", name);
        } else {
            log.info("{} successfully joined the house as {}", name, assignedRole);
        }
    }

    public void leaveHouse() {
        if (house != null && assignedRole != null) {
            house.releaseRole(name);
            assignedRole = null;
            house = null;
        } else {
            log.warn("{} tried to leave the house but was not part of any house", name);
        }
    }
}
