package derschrank.sprint03.task10.bjstwo_48849;

import lombok.Getter;

import java.util.List;

public class User {

    private final String name;
    @Getter
    private Role role;

    public User(String name) {
        this.name = name;
    }

    void joinHouse(HouseInterface house) {
        if (!hasArole()) {
            synchronized (house) {
                while (house.getAvailableRoleCount() == 0) {
                    System.out.println(this + ": House hasn't any vacant role. Wait for...");
                    waitForNotification(house);
                }
                role = house.getRole(this);
                System.out.println(this + ": Became the role: " + role);
            }
        }
    }

    void leaveHouse(HouseInterface house) {
        if (hasArole()) {
            synchronized (house) {
                System.out.print(this + ": Released the role: " + role);
                role = house.releaseRole(this);
                System.out.println(", and now has role: " + role);
                house.notifyAll();
            }
        }
    }


    private void waitForNotification(HouseInterface house) {
        try {
            house.wait();
        } catch (InterruptedException e) {
            System.out.println("User " + this + " was interrupted: " + e);
        }
    }

    private boolean hasArole() {
        return role != null;
    }

    @Override
    public String toString() {
        return name;
    }
}
