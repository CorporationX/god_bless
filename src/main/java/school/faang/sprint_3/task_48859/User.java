package school.faang.sprint_3.task_48859;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class User {
    private String name;
    private House joinedHouse;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(@NonNull House house) {
        synchronized (house) {
            while (house.getAvailableCountRoles() == 0) {
                try {
                    System.out.println(name + " waiting");
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Role assignedRole = house.addPlayer();
            joinedHouse = house;
            role = assignedRole;
            System.out.println(name + " joined to house and take role " + role);
        }
    }

    public void leaveHouse() {
        synchronized (joinedHouse) {
            joinedHouse.removePlayer(role);
            joinedHouse.notify();
            joinedHouse = null;
            role = null;
            System.out.println(name + " leave from house");
        }
    }
}
