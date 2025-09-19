package bjs290289;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole(name);
            this.house = house;
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                house.releaseRole(assignedRole, name);
                assignedRole = null;
                house = null;
            }
        }
    }
}
