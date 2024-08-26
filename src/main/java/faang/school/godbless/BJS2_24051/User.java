package faang.school.godbless.BJS2_24051;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Getter
@Setter
@Slf4j
@ToString
public class User {
    private String name;
    private House house;
    private Role role;

    public User(String name, House house, Role role) {
        this.name = name;
        this.house = house;
        this.role = role;
    }

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            if (this.house.getFreeRoles() == 0){
                log.info("Waiting for a free role in house");
                house.wait();
            }


            this.role = this.house.getRoles().get(new Random().nextInt(3));
            log.info("{} is adding to the house", this.role);
            this.house.addRole();
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            this.role = null;
            this.house.removeRole();
        }
    }
}
