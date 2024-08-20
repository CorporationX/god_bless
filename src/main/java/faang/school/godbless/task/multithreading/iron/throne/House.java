package faang.school.godbless.task.multithreading.iron.throne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
public class House {
    private final Object lock = new Object();
    private final String name;
    private final List<Role> roles = new ArrayList<>(List.of(Role.values()));
    private int numberOfAvailableRoles = Role.values().length;

    public int getNumberOfAvailableRoles() {
        synchronized (lock) {
            return numberOfAvailableRoles;
        }
    }

    public List<Role> getRoles() {
        synchronized (lock) {
            return roles;
        }
    }

    public void addRole(Role role) {
        synchronized (lock) {
            roles.add(role);
            log.info("В доме {} освободилась роль {}", this.name, role);
            numberOfAvailableRoles++;
            lock.notifyAll();
        }
    }

    public void removeRole(Role role) {
        synchronized (lock) {
            roles.remove(role);
            numberOfAvailableRoles--;
        }
    }
}
