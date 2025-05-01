package school.faang.bjs2_73288;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@AllArgsConstructor
public class House {
    public static final int WAITING_TIME = 30000;
    private Set<Role> availableRoles;
    private final Object lock = new Object();

    public Role assignRole() {
        Role roleToAssign;
        synchronized (lock) {
            while (availableRoles.isEmpty()) {
                log.info("There is no any single available role to assign");
                try {
                    lock.wait(WAITING_TIME);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("The thread was interrupted while waiting for available roles to" +
                            " assign", e);
                }
            }
            roleToAssign = availableRoles.iterator().next();
            availableRoles.remove(roleToAssign);
            log.info("Role '{}' was assigned", roleToAssign);
        }
        return roleToAssign;
    }

    public void releaseRole(Role role) {
        synchronized (lock) {
            availableRoles.add(role);
            lock.notifyAll();
            log.info("Role '{}' was released", role);
        }
    }
}
