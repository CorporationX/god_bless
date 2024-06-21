package faang.school.godbless.theIronThroneatAnyCost;

import lombok.Getter;
import org.w3c.dom.ls.LSOutput;

@Getter
public class User {
    public String name;
    private Role role;
    private House house;

    public User(String name, Role role, House house) {
        this.name = name;
        this.role = role;
        this.house = house;
    }

    private Object lock = new Object();

    public void joinHouse(House house) {
        System.out.println("joinHouse");
        synchronized (lock) {
            if (house.getAvailableRoles().isEmpty()) {
                try {
                    System.out.println("kqswkdsjwk");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Role vacantRole = house.getAvailableRoles().iterator().next();

            house.getUserRoles().put(this, vacantRole);

            System.out.printf("New user %s on house%n", this.name);

            house.removeRole(vacantRole);

        }
    }

    public void leaveHouse(House house) {
        System.out.println("leaveHouse");
        synchronized (lock) {
            if (house.getUserRoles().containsKey(this)) {
                synchronized (lock) {
                    house.getUserRoles().remove(this);
                    house.addRole(house.getUserRoles().get(this), lock);
                }
            } else {
                throw new IllegalStateException("User " + this.name + " is not in the house");
            }
        }
    }
}
