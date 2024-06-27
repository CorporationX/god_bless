package faang.school.godbless.synchronization.throne;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    private static final Object lock = new Object();

    private String name;
    private House house;
    private final Role role;

    public User(String name, Role role) {
        this.name = name;
        this.house = null;
        this.role = role;
    }

    public void joinHouse(@NonNull House house) {
        if (house.getRolesMap().containsKey(role)) {
            synchronized (lock) {
                if (house.getRolesMap().get(role) == 0) {
                    synchronized (role) {
                        try {
                            System.out.println("Try to get role " + role + " by user " + name + ". All roles are busy. Wait ...");
                            role.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                this.house = house;
                System.out.println("User " + name + " join house " + house.getName());
                house.addRole(role);
            }
        } else {
            System.out.println("House does not have this role - " + role);
        }
    }

    public void leaveHouse(@NonNull House house) {
        if (house.getRolesMap().containsKey(role)) {
            synchronized (role) {
                house.removeRole(role);
                System.out.println("User " + name + " leave house " + house.getName());
                role.notifyAll();
            }
        }
    }
}
