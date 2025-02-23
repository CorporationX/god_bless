package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        this.house = house;
        assignedRole = house.assignRole();
        logger.info("{} joined the house and selected the {}.", name, assignedRole);
    }

    public void leaveHouse() {
        logger.info("{} leaves the house and vacating the {}.", name, assignedRole);
        house.releaseRole(assignedRole);
        assignedRole = null;
        house = null;
    }
}
