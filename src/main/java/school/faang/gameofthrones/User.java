package school.faang.gameofthrones;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class User {
    private String name;
    private House house;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(@NonNull House house, Role role) {
        synchronized (house) {
            while (house.getCurrentNumOfAvailableRoles() == 0 || !house.getAvailableRoles().contains(role)) {
                try {
                    System.out.println("The role of the " + role.getName() + " in the " + house.getName() + " house is occupied, " +
                            "please wait for the role to become available!");
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.error("Another thread interrupted the current thread while it was waiting: ", e);
                }
            }
            this.house = house;
            this.role = role;
            house.removeRole(role);
            System.out.println("Player " + name + " entered the " + house.getName() + " house and chose the role of " +
                    role.getName());
        }
    }

    public synchronized void leaveHouse(@NonNull House house) {
        synchronized (house) {
            if (this.house != null && this.role != null) {
                house.addRole(this.role);
                System.out.println("Player " + name + " left the " + house.getName() + " house and vacated the role of " +
                        role.getName());
                this.house = null;
                this.role = null;
                house.notifyAll();
            }
        }
    }
}
