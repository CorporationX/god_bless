package school.faang.throne;

import static school.faang.throne.House.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {
    private final String name;
    private final Role role;
    private House house;

    public synchronized void joinHouse(House house) throws InterruptedException {
        this.house = house;
        synchronized (house) {
            while (!house.addRole(role)) {
                System.out.println(name + " is waiting for a role in " + house.getHouseName());
                house.wait();
            }
            System.out.println(name + " joined house " + house.getHouseName() + " with role " + role);

        }
    }

    public void leaveHouse(House house) {
        if (house != null) {
            synchronized (house) {
                house.removeRole(role);
                System.out.println(name + " left house " + house.getHouseName());
            }
        }
    }
}
