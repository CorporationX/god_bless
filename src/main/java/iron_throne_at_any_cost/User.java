package iron_throne_at_any_cost;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class User {
    private final String name;

    private final House house;

    private Role role;

    public void joinHouse() {
        synchronized (house) {
            if (house.getAvailableRolesCount() == 0) {
                try {
                    System.out.println("Нет доступных ролей, ждем");
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int rolesCount = house.getRoles().size();
            this.role = house.getRoles().get(new Random().nextInt(rolesCount));
            house.addRole();
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole();
            this.role = null;
        }
    }
}
