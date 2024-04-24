package TheIronThrone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private static final Object LOCK = new Object();
    private String userName;
    private House house;
    private Role role;

    public void joinHouse() {
        initialization(house, role);
        synchronized (LOCK) {
            int maxSize = house.getAvailableRoles().get(role);
            if (maxSize == House.MAX_ROLE_SIZE) {
                System.out.println(userName + " подождите, все роли заняты...");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            house.addRole(role);
            System.out.println(userName + " зашёл в дом " + house.getName());
        }
    }

    public void leaveHouse() {
        initialization(house, role);
        synchronized (LOCK) {
            house.removeRole(role);
            System.out.println(userName + " покинул дом " + house.getName());
            LOCK.notifyAll();
        }
    }

    private void initialization(House house, Role role) {
        if (house == null || role == null) {
            throw new IllegalArgumentException("House or Role is null.");
        }
    }
}
