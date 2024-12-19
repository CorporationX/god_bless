package school.faang.task_48888;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter
@ToString
public class User {
    private static final Logger log = LoggerFactory.getLogger(User.class);
    private final String name;
    private House houseName;
    private UserRole userRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, UserRole role) {
        synchronized (house) {
            if (!(house.getPossiblePosition() > 0) || !house.getUserRoles().contains(role)) {
                log.info("Waiting for a free position or role...");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            house.addRole(role);
            this.houseName = house;
            this.userRole = role;
            log.info("{} successfully joined house", name);
        }
    }

    public void leaveHouse() {
        if (houseName == null || userRole == null) {
            log.info("{} Not part of any house", name);
            return;
        }
        synchronized (houseName) {
            houseName.removeRole(userRole);
            houseName.notifyAll();
            log.info(" {} leaving house {}", name, houseName.getHouseName());
            this.houseName = null;
            this.userRole = null;
        }
    }
}
