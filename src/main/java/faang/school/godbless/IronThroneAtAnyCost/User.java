package faang.school.godbless.IronThroneAtAnyCost;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
@Getter
public class User {
    private static final Random RANDOM = new Random();
    private String name;
    private House house;
    private String houseName;
    private String role;
    //private final Object lock = new Object();

    public synchronized void joinHouse(House house) {
            List<String> avaliableRoles = house.getAvaliableRoles();
            if (house.getNumOfAvaliableRoles() <= 0) {
                log.info(this.name + " is waiting");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("available.wait() in joinHouse was interrupted while waiting " + e);
                }
            } else {
                this.role = avaliableRoles.get(RANDOM.nextInt(avaliableRoles.size()));
                this.house = house;
                this.houseName = house.getName();
                log.info(this.name + " got role " + this.role + " in " + this.houseName + "'s house");
                house.addRole(this.role);
            }
            inHouseAction();
    }

    public void inHouseAction() {
        log.info(this.name + " doing some House action...");
        try {
            Thread.sleep(RANDOM.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.leaveHouse();
    }

    public synchronized void leaveHouse() {
            List<String> avaliableRoles = this.house.getAvaliableRoles();
            house.removeRole(role);
            log.info(this.name + " leaved " + this.houseName + "'s house");
            notifyAll();
    }

    public User(String name) {
        this.name = name;
    }
}
