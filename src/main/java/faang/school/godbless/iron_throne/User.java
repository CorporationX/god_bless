package faang.school.godbless.iron_throne;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class User {
    private String name;
    private House house;
    private HouseRole role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, HouseRole houseRole) {
        synchronized (house) {
            while (house.getRolesMap().get(houseRole) <= 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            house.addRole(houseRole);
            this.house = house;
            this.role = houseRole;
            log.info("User with name {}, was joined to {}, with role {}", name, house.getName(), houseRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            house.removeRole(this.role);
            log.info("User with name {}, was leaved {}, with role {}", name, house.getName(), this.role);
            this.house = null;
            this.role = null;
        }
    }
}