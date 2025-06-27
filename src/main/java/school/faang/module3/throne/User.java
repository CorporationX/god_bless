package school.faang.module3.throne;

import lombok.NonNull;

public class User {
    private String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(@NonNull House house) {
        synchronized (house) {
            System.out.printf("%s try to join to house %s\n", name, house.getName());
            assignedRole = house.assignRole();
            this.house = house;
            System.out.printf("%s joined to house %s\n", name, house.getName());
        }
    }

    public void leaveHouse() {
        if (this.house == null) {
            System.out.println("user is not a member of any house");
            return;
        }
        synchronized (this.house) {
            if (house != null) {
                house.releaseRole(assignedRole);
                System.out.printf("%s leaved house %s\n", name, house.getName());
            }
        }
    }
}
