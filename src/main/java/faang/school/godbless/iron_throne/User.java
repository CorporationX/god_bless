package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class User {
    private final Object lock = new Object();
    private String userName;
    private House userHouse;
    private String userRole;

    public User(String userName) {
        this.userName = userName;
    }

    public synchronized void joinHouse(House desiredHouse, String desiredRole) {
        synchronized (lock) {
            if(desiredHouse.getAvailableRoles() > 0 && desiredHouse.getRoles().contains(desiredRole)) {
                userHouse = desiredHouse;
                userRole = desiredRole;
                desiredHouse.addRole(desiredRole);
                System.out.println("New player " + userName + " become a " + userRole + " of the " + userHouse.getName() + " house!");
            } else {
                try {
                    lock.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void leaveHouse(House houseForLeave) {
        synchronized (lock) {
            if(userHouse != null) {
                houseForLeave.removeRole(userRole);
                System.out.println(userName + " leave the house of " + userHouse.getName());
                lock.notifyAll();
            }
        }
    }
}
