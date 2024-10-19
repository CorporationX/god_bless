package school.faang.godbless.bjs2_37083;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private final House house;
    private String name;
    private String role = null;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            role = house.removeRole();
            log.info("User {} has joined the house and now has a role {}", name, role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.addRole(role);
            role = null;
            log.info("User {} has left the house and now has no role", name);
        }
    }
}
