package faang.school.godbless.BJS224422;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class House {
    private final Set<String> availableRoles = new HashSet<>();

    public synchronized boolean joinHouse(String role) throws InterruptedException {
        if (!availableRoles.contains(role)) {
            wait();
        }
        availableRoles.remove(role);
        return true;
    }

    public synchronized void leaveHouse(String role) {
        availableRoles.add(role);
        notifyAll();
    }

    public void addRole(String role) {
        synchronized (this) {
            availableRoles.add((role));
            notifyAll();
        }
    }

    public void removeRole(String role) {
        synchronized (this) {
            availableRoles.remove(role);
        }
    }
}
