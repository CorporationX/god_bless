package ironThrone;

import lombok.Data;

import java.util.List;

@Data
public class House {
    private final static List<String> ROLES = List.of("King", "Swordman", "Archer", "Salesman");
    private int amountRoles;
    private final Object lock = new Object();

    public House() {
        this.amountRoles = 5;
    }

    public void addRole(String role) {
        checkRoleForEmpty(role);
        synchronized (lock) {
            if (amountRoles <= 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            amountRoles--;
        }

    }

    public void removeRole(String role) {
        checkRoleForEmpty(role);
        amountRoles++;
        lock.notifyAll();
    }

    private void checkRoleForEmpty(String role) {
        if (role.isEmpty()) {
            throw new NullPointerException("Role doesnt be empty");
        }
    }
}
