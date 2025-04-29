package gameofthrones;

import lombok.Setter;

public class User implements Runnable {
    private String name;
    @Setter
    private House house;
    private String assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        assignedRole = house.assignRole();
        this.house = house;
        System.out.println(name + " joined the " + assignedRole + " house");
    }

    public void leaveHouse() {
        if (house != null && assignedRole != null) {
            System.out.println(name + " is leaving house and releasing the role " + assignedRole);
            house.releaseRole(assignedRole);
            assignedRole = null;
            house = null;
        }
    }

    @Override
    public void run() {
        joinHouse(house);
        try {
            Thread.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        leaveHouse();
    }

}
