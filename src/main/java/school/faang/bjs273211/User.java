package school.faang.bjs273211;

import lombok.Getter;

public class User {
    @Getter
    private String name;
    private String assignedRole;
    private House house;
    private final Object lock = new Object();

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (lock) {
            this.house = house;
            assignedRole = house.assignRole();
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }
        }
    }
}
