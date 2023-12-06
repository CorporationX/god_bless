package faang.school.godbless.IronThrone;

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
        if (house.getAvailableRolesQuantity() > 0) {
            String role = house.getAvailableRoles().get(0);

            this.setHouse(house);
            this.setRole(role);

            house.removeRole(role);
            System.out.println(this.name + " joined house and got " + role + " role");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void leaveHouse() {
        this.house.addRole(this.role);
        System.out.println(this.name + " leaved house and " + this.role + " is available now");

        this.setHouse(null);
        this.setRole("");
    }

    public void emulateJoinLeave(House house){
        this.joinHouse(house);

        try {
            Thread.sleep(new Random().nextInt(1000, 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.leaveHouse();
    }
}
