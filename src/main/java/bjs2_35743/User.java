package bjs2_35743;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class User {
    private final String name;
    private House house;
    private String role;

    public synchronized void joinHouse(House house, String role) throws InterruptedException {
        synchronized (house) {
            if (house.getAvailableRolesAmount() == 0) {
                house.wait();
            }
            house.removeRole(role);
            System.out.printf("%s joined house %s as a %s\n", name, house, role);
            this.house = house;
            this.role = role;
        }
    }

    public synchronized void leaveHouse() {
        if (house.equals(null)) {
            System.out.println("No house to leave from");
            return;
        }

        synchronized (house) {
            house.addRole(role);
            System.out.printf("%s left house %s\n", name, house);
            this.house = null;
            this.role = null;
        }
    }
}
