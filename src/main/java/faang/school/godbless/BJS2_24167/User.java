package faang.school.godbless.BJS2_24167;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter
@RequiredArgsConstructor
public class User {

    private static final Logger log = LoggerFactory.getLogger(User.class);
    private final String name;
    private House house;
    private String role;

    public void joinHouse(House house, String role) {
        synchronized (house.getRoles()) {
            while (!house.isAvailableRole(role)) {
                try {
                    System.out.println(name + " waiting for " + role + " in " + house.getName());
                    house.getRoles().wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            house.addRole(role);
            this.house = house;
            this.role = role;
            System.out.println(name + " joined house " + house.getName() + " role " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house.getRoles()) {
            if (house == null || role == null) {
                return;
            }
            house.removeRole(role);
            System.out.println(name + " left house " + house.getName() + " role " + role);
            this.house = null;
            this.role = null;
        }
    }
}
