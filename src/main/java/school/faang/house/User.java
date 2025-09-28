package school.faang.house;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Runnable {
    private String name;
    private Role role;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) {
        this.house = house;
        house.assignRole(this, role);
    }

    public void leaveHouse() {
        if (house != null && role != null) {
            house.releaseRole(this);
        }
    }

    @Override
    public void run() {
        try {
            joinHouse(this.house, this.role);
            Thread.sleep((long) (Math.random() * 3000));
            leaveHouse();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}