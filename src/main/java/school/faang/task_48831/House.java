package school.faang.task_48831;

import lombok.Data;

import java.util.List;

@Data
public class House {
    private final List<Role> roles;

    public void addRole(Role role, User user) {
        role.setUser(user);
        user.setBusyRole(role);
        user.setHouse(this);
    }

    public synchronized void removeRole(Role role, User user) {
        user.setHouse(null);
        role.setUser(null);
        user.setBusyRole(null);
        notifyAll();
    }
}
