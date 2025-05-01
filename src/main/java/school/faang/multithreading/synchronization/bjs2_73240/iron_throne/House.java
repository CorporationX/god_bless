package school.faang.multithreading.synchronization.bjs2_73240.iron_throne;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class House {

    private final List<Role> roles;

    public Role assignRole() {
        synchronized (roles) {
            while (roles.isEmpty()) {
                try {
                    log.info("There is no available roles, waiting is starting");
                    roles.wait();
                } catch (InterruptedException e) {
                    log.error("Error during waiting: {} ", e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
            return roles.remove(new Random().nextInt(roles.size()));
        }
    }

    public void releaseRole(User user) {
        synchronized (roles) {
            roles.add(user.getRole());
            user.setRole(null);
            roles.notifyAll();
        }
    }

    public void printRoles() {
        synchronized (roles) {
            log.info("Roles: {}", roles);
        }
    }
}
