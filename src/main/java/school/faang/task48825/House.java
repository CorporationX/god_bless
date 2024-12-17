package school.faang.task48825;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Getter
@Slf4j
@AllArgsConstructor
public class House {

    private final String nameHouse;
    private final Set<Role> availableRoles;

    public void addRole(Role role) {
        while (!getAvailableRoles().contains(role)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.info(e.getMessage());
            }
        }
        availableRoles.remove(role);
    }

    public void removeRole(Role role) {
        availableRoles.add(role);
        this.notify();
    }
}
