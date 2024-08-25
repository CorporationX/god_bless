package faang.school.godbless.Iron_Throne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private String name;
    private House house;
    private String role;
    private final Object lock = new Object();

    public void joinHouse(House house) {
        synchronized (lock) {
            while (house.getRoles().size() <= house.getCapturedRoles().size()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setHouse(house);
                Set<String> availableRoles = new HashSet<>(house.getRoles());
                availableRoles.removeAll(house.getCapturedRoles().keySet());
                String freeRole = availableRoles.iterator().next();
                house.getCapturedRoles().put(freeRole, this);
                setRole(freeRole);
                lock.notifyAll();
            }
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            if (house != null) {
                house.getCapturedRoles().remove(role);
                setRole(null);
                setHouse(null);
                lock.notifyAll();
            }
        }
    }
}