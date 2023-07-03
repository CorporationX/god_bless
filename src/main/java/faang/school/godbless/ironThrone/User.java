package faang.school.godbless.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private final House house;
    private RoleRecord role;

    public void joinHouse() {
        synchronized (house) {
            if (!getHouse().getAvailableRoles().contains(role)) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                house.removeRole(role);
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.addRole(role);
        }
    }
}
