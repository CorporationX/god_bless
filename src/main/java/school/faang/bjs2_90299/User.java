package school.faang.bjs2_90299;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
public class User {
    private final String name;
    private Role assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            log.info("{} got a role {} in the house", name, assignedRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            house.releaseRole(assignedRole);
            log.info(" {} left the house. left home. He had a role {}", name, assignedRole);
            assignedRole = null;
        }
    }
}
