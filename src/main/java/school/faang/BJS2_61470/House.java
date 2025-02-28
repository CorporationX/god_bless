package school.faang.BJS2_61470;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Getter
@Slf4j
public class House {
    private final String name;
    private final List<String> roles;

    public String assignRole() {
        synchronized (roles) {
            while (roles.isEmpty()) {
                try {
                    roles.wait();
                } catch (InterruptedException e) {
                    log.error(ConstAndMessages.ERROR_OF_WAITING_ROLE, e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            log.info(ConstAndMessages.ROLE_IS_OCCUPIED, name, roles.get(0));
            return roles.remove(0);
        }
    }

    public void releaseRole(@NonNull String role) {
        synchronized (roles) {
            roles.add(role);
            log.info(ConstAndMessages.ROLE_IS_VACANT, name, roles.get(0));
            roles.notifyAll();
        }
    }
}
