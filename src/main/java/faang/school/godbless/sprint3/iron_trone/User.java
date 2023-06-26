package faang.school.godbless.sprint3.iron_trone;

import lombok.Data;

@Data
public class User {
    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, String role) {
        synchronized (house) {
            while (house.getAvailableRoles() == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.house = house;
            this.role = role;
            house.removeRole(role);
            house.setAvailableRoles(house.getAvailableRoles() - 1);
            house.notifyAll();
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            house.addRole(role);
            this.house = null;
            this.role = null;
            house.setAvailableRoles(house.getAvailableRoles() + 1);
            house.notifyAll();
        }
    }

}
