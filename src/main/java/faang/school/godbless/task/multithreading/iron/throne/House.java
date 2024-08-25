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
    private final String name;
    private final List<Role> roles = new ArrayList<>(List.of(Role.values()));
    private int numberOfAvailableRoles = Role.values().length;

    public int getNumberOfAvailableRoles() {
        synchronized (this) {
            return numberOfAvailableRoles;
        }
    }

    public List<Role> getRoles() {
        synchronized (this) {
            return roles;
        }
    }

    public void addRole(Role role) {
        synchronized (this) {
            roles.add(role);
            log.info("В доме {} освободилась роль {}", this.name, role);
            numberOfAvailableRoles++;
            this.notifyAll();
        }
    }

    public void removeRole(Role role) {
        synchronized (this) {
            roles.remove(role);
            numberOfAvailableRoles--;
        }
    }
}
