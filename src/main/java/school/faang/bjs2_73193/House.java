package school.faang.bjs2_73193;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class House {

    private static final int TIMEOUT = 2000;

    private final Map<Role, Boolean> roles = new HashMap<>();

    public House(List<Role> rolesToAssign) {
        for (Role role : rolesToAssign) {
            roles.put(role, false);
        }
    }

    public Role assignRole() {
        synchronized (this) {
            while (true) {
                var available = roles.entrySet().stream()
                        .filter(kv -> !kv.getValue())
                        .findFirst();

                if (available.isPresent()) {
                    Role role = available.get().getKey();
                    roles.put(role, true);
                    return role;
                }

                try {
                    log.info("All roles are taken, wait for role to release");
                    this.wait(TIMEOUT);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void releaseRole(Role role) {
        synchronized (this) {
            roles.put(role, false);
            this.notify();
        }
    }
}
