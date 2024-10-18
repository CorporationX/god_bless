package school.faang.m1s3.bjs2_37057_ironThrone;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {
    private final String name;
    private House house;
    private Role role;

    public void joinHouse(House house, Role role) {
        synchronized (house.getAvailableRoles()) {
            if (!house.getAvailableRoles().contains(role)) {
                try {
                    System.out.println("Dear " + name + ", all roles are occupied. Please wait");
                    house.getAvailableRoles().wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
                }
            }
            this.house = house;
            this.role = role;
            house.removeAvailableRole(role);
            System.out.println("New " + role + " of House " + house.getName() + " is " + name);
        }
    }

    public void leaveHouse() {
        if (this.house == null || this.role == null) {
            throw new IllegalStateException("You don't belong to any house ");
        }

        synchronized (house.getAvailableRoles()) {
            System.out.println(role + " " + name + " leaves House " + house.getName());
            house.addAvailableRole(this);
            house.getAvailableRoles().notify();
            this.role = null;
            this.house = null;
        }
    }
}


