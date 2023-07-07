package faang.school.godbless.iron_throne;

import lombok.Getter;

@Getter
public class User {

    private String name;
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House houses, String roles) {
        house = houses;
        synchronized (house) {
            if (!house.getRoles().contains(roles) || house.getAvailableRoles() == 0) {
                System.out.println(name + " is waiting");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.role = roles;
            house.removeRole(roles);
            System.out.println(name + " is " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " is not " + role);
            house.addRole(role);
            house.notifyAll();
        }
    }
}
