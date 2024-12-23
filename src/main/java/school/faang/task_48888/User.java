package school.faang.task_48888;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Setter
@Getter
@ToString
public class User {
    private static final Logger log = LoggerFactory.getLogger(User.class);
    private final String name;
    private Optional<House> houseName;
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
            this.houseName = Optional.of(house);
            this.userRole = role;
            log.info("{} successfully joined house", name);
        }
    }

    public void leaveHouse() {
        if (houseName.isEmpty()) {
            log.info("{} Not part of any house", name);
            return;
        }
        House house = houseName.get();
        synchronized (house) {
            houseName.get().removeRole(userRole);
            house.notifyAll();
            log.info(" {} leaving house {}", name, houseName.get().getHouseName());
            this.houseName = Optional.empty();
            this.userRole = UserRole.NONE;
        }
    }
}
