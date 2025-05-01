package school.faang.multithreading.synchronization.bjs2_73240.iron_throne;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class User {
    private String name;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        if (house != null) {
            this.role = house.assignRole();
            log.info("User {} joins to house with role {}", name, role);
        }
    }

    public void leaveHouse(House house) {
        if (house != null && role != null) {
            log.info("User {} leaves house with role {}", name, role);
            house.releaseRole(this);
        }
    }
}
