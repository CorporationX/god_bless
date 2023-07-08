package Multithreading.bc3008;

import lombok.Data;

import java.util.Random;

@Data
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        int random = new Random().nextInt(0, house.roles.size());
        if (house.getCountFreeRole() > 0) {
            String getRole = house.roles.get(random);

            this.setHouse(house);
            this.setRole(getRole);

            house.removeRole(getRole);
            System.out.println(this.name + " joined house and got " + getRole + " role");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void leaveHouse() {
        this.house.addRole(role);

        System.out.println(this.name + " leaved house and " + role + " is available now");

        this.setHouse(null);
        this.setRole("");
    }

    public void joinLeaveHouse(House house) {
        this.joinHouse(house);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.leaveHouse();
    }
}
