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
    private static final House EMPTY_HOUSE = new EmptyHouse();
    private final String name;
    private House houseName = EMPTY_HOUSE;
    private UserRole userRole;

    public User(String name, UserRole userRole) {
        this.name = name;
        this.userRole = userRole;
    }

    public void joinHouse(House house, UserRole role) {
        synchronized (house) {
            while (!(house.getPossiblePosition() > 0) || !house.getUserRoles().contains(role)) {
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
        if (houseName==EMPTY_HOUSE) {
            log.info("{} Not part of any house", name);
            return;
        }
        synchronized (houseName) {
            houseName.removeRole(userRole);
            houseName.notifyAll();
            log.info(" {} leaving house {}", name, houseName.getHouseName());
            this.houseName = EMPTY_HOUSE;
            this.userRole = UserRole.NONE;
        }
    }
}
