package derschrank.sprint03.task10.bjstwo_48849;

import lombok.Getter;

public class User {
    @Getter
    private final String name;
    private Role role;
    private HouseInterface house;

    public User(String name) {
        this.name = name;
    }

    synchronized void joinHouse(HouseInterface house) {
        if (!hasArole()) {
            this.house = house;
            synchronized (house) {
                while (house.getAvailableRoleCount() == 0) {
                    System.out.println(this + ": = House hasn't any vacant role. Wait for...");
                    waitForNotification();
                }
                role = house.getRole();
                System.out.println(this + ": + Became the role: " + role);
            }
        }
    }

    synchronized void leaveHouse() {
        if (hasArole()) {
            synchronized (house) {
                System.out.println(this + ": - Released the role: " + role);
                house.releaseRole(role);
                role = null;
                house.notifyAll();
                house = null;
            }
        }
    }

    private void waitForNotification() {
        try {
            house.wait();
        } catch (InterruptedException e) {
            System.out.println("User " + this + " was interrupted: " + e);
        }
    }

    private boolean hasArole() {
        return role != null && house != null;
    }

    @Override
    public String toString() {
        return name;
    }
}