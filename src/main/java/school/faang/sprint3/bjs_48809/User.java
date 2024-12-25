package school.faang.sprint3.bjs_48809;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
public class User {
    private final String name;
    private String chosenRole;
    Random random = new Random();

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getFreeRolesCount() == 0) {
                log.info("{} waiting for available roles", name);
                house.wait();
            }
            chosenRole = choseRole(house.getAvailableRoles());
            house.getTheRole(chosenRole);
            log.info("{} chose the role {}", name, chosenRole);
        }
    }

    private String choseRole(List<String> availableRoles) {
        return availableRoles.get(random.nextInt(availableRoles.size()));
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            log.info("{} leave the house", name);
            house.releaseRole(chosenRole);
            house.notifyAll();
        }
    }
}
