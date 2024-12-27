package school.faang.bjs248847;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User implements Runnable {
    private final String name;
    private House house;
    private String chosenRole;

    public User(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty.");
        }
        this.name = name;
        log.info("User created: {}", name);
    }

    public synchronized void joinHouse(House house) {
        try {
            if (house == null) {
                throw new IllegalArgumentException("House cannot be null.");
            }
            synchronized (house) {
                if (!house.isAvailableRoleList()) {
                    log.info("{} is waiting for a role to become available in the house.", name);
                    try {
                        house.wait();
                    } catch (InterruptedException e) {
                        log.error("Thread interrupted while waiting for a role to become available.", e);
                    }
                }
                String role = house.addRole();
                this.chosenRole = role;
                this.house = house;
            }
        } catch (IllegalArgumentException e) {
            log.error("An error occurred: {}", e.getMessage());
        }
    }

    public synchronized void leaveHouse() {
        if (house != null && chosenRole != null) {
            synchronized (house) {
                log.info("{} is leaving the house and releasing the role: {}", name, chosenRole);
                try {
                    house.removeRole(chosenRole);
                } catch (Exception e) {
                    log.error("An error occurred while removing the role: {}", e.getMessage());
                }
                chosenRole = null;
                house = null;
            }
        } else {
            log.warn("{} is not part of any house to leave.", name);
            throw new IllegalStateException(" User is not part of any house to leave");
        }
    }

    @Override
    public void run() {
        try {
            joinHouse(house);
            Thread.sleep(2000);
            leaveHouse();
        } catch (Exception e) {
            log.error("An error occurred in the run method: {}", e.getMessage());
        }
    }
}