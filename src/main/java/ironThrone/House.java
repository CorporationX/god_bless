package ironThrone;

import lombok.Data;

import java.util.Map;

@Data
public class House {
    private Map<String, Locker> roles;
    private int amountRoles = 4;
    private final Object lock = new Object();
    private String name;

    public House(String name, Map<String, Locker> roles) {
        this.name = name;
        this.roles = roles;
    }

    public void addRole(User user, String role) {
        checkUser(user);
        if (!roles.containsKey(role)) {
            throw new IllegalArgumentException("Uncorrected role");
        }
        synchronized (roles.get(role)) {
            if (!roles.get(role).isOpen()) {
                try {
                    roles.get(role).wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            user.setHouse(this);
            user.setRole(role);
            roles.get(role).setOpen(false);
            amountRoles--;
        }
    }

    public void removeRole(User user) {
        synchronized (roles.get(user.getRole())) {
            checkUser(user);
            user.setHouse(null);
            roles.get(user.getRole()).setOpen(true);
            roles.get(user.getRole()).notify();
            user.setRole("");
            amountRoles++;
        }
    }

    private void checkUser(User user) {
        if (user == null) {
            throw new NullPointerException("User must be exist");
        }
    }
}
