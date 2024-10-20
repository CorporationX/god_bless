package school.faang.sprint_3.bjs2_37370_ironThrone;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class User {
    private static final Random RANDOM = new Random();
    private final String name;
    private House house;
    private String roleName;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house.getLock()) {
            while (house.getAvailableRoles().isEmpty()) {
                try {
                    log.info("{} waiting free role in {}", name, house.getName());
                    house.getLock().wait();
                } catch (InterruptedException e) {
                    log.error("An error occurred while waiting for a free role.", e);
                    throw new RuntimeException(e);
                }
            }

            List<String> availableRoles = new ArrayList<>(house.getAvailableRoles());
            String randomRole = availableRoles.get(RANDOM.nextInt(availableRoles.size()));
            setHouseAndRole(house, randomRole);
            house.removeAvailableRole(randomRole);
            log.info("{} joined {} and got the role {}.\nAvailable roles count {}.", name, house.getName(), roleName,
                    house.getAvailableRoles().size());
        }
    }

    public void leaveHouse() {
        synchronized (house.getLock()) {
            if (this.house != null && this.roleName != null) {
                house.addAvailableRole(roleName);
                log.info("{} leaves {} and vacates the role {}.\nAvailable roles count {}.", name, house.getName(),
                        roleName, house.getAvailableRoles().size());
                house.getLock().notifyAll();
                setHouseAndRole(null, null);
            }
        }
    }

    private void setHouseAndRole(House house, String roleName) {
        this.house = house;
        this.roleName = roleName;
    }
}