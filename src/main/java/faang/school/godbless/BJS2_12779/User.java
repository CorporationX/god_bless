package faang.school.godbless.BJS2_12779;

import lombok.Getter;

public class User {
    private final String name;
    @Getter
    private House house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User " + name + " " + role;
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            if (house.getAccessibleRolesCount() > 0) {
                this.role = house.addRole();
                this.house = house;
            } else {
                wait();
            }
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            house.removeRole();
            this.role = "";
            this.house = null;
        }
    }
}
