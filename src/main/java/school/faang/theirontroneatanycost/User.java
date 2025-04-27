package school.faang.theirontroneatanycost;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class User {
    private final String name;
    private Role assignRole;

    public void joinHouse(@NonNull House house, @NonNull Role role) {
        synchronized (house) {
            while (house.isRoleAssigned(role)) {
                log.info("User {} is waiting for the role {}...", this.getName(), role.getName());
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Thread was interrupted while waiting!");
                    return;
                }
            }
            assignRole = role;
            house.assignRole(role);
        }

    }

    public void leaveHouse(@NonNull House house) {
        synchronized (house) {
            house.releaseRole(this.assignRole);
            this.assignRole = null;
            house.notifyAll();
        }
    }
}
