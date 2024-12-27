package school.faang.bjs48916;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    @Getter
    private final String name;
    private final House house;
    private House.Role role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() {
        while (house.getAvailableRoles().isEmpty()) {
            log.info("No available roles for {}", name);
            try {
                Thread.sleep(House.GOVERNANCE_PERIOD / 2);
            } catch (InterruptedException e) {
                log.error("Error while trying to acquire some role");
            }
        }
        var optRole = house.getAvailableRoles().stream().findAny();
        House.Role tryRole;
        if (optRole.isPresent()) {
            tryRole = optRole.get();
        } else {
            return;
        }
        if (house.joinHouse(this, tryRole)) {
            role = tryRole;
            log.info("{} acquired role {}", name, tryRole);
        } else {
            joinHouse();
        }
    }

    public void leave() {
        this.role = null;
    }
}
