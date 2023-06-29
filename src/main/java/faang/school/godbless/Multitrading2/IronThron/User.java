package faang.school.godbless.Multitrading2.IronThron;

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
            house.addRole(role);
            System.out.println("House joined by " + role);
            house.notifyAll();
        }
    }
    public void leaveHouse(House house) {
        synchronized (house){
            house.removeRole(role);
            this.house = null;
            System.out.println("House leaved by " + role);
            this.role = null;
            house.notifyAll();
        }
    }
}
