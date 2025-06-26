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

    public void joinHouse(House house) {
        synchronized (house) {
            this.assignedRole = house.assignRole(name);
            if (assignedRole == null) {
                log.warn("{} could not join the house — no roles available", name);
            } else {
                log.info("{} successfully joined the house as {}", name, assignedRole);
            }
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            if (assignedRole != null) {
                house.releaseRole(name);
                log.info("{} has left the house", name);
                assignedRole = null;
            } else {
                log.warn("{} tried to leave the house but had no assigned role", name);
            }
        }
    }
}
