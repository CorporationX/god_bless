package school.faang;

import java.util.logging.Logger;

public class User extends Thread {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private final String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            System.out.println(name + "выбрал роль" + assignedRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                logger.info(name + " покидает дом и освобождает роль: " + assignedRole);
                house.releaseRoel(assignedRole);
                assignedRole = null;
                house = null;
            } else {
                logger.warning(name + " не может покинуть дом, так как роль не назначена или дом отсутствует.");
            }
        }
    }
}

