package faang.school.godbless.synchronization.game_of_trones;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private Role role;
    private final Object lock = new Object();

    public void joinHouse() throws InterruptedException {
        synchronized (lock) {
            if (house.getAvailableRoles().isEmpty()) {
                lock.wait();
            }
            log.info(String.format("%s join house with role:%s", name, role.name()));
            house.addRole(role);
        }
    }

    public void leaveHouse() {
        synchronized (lock) {
            log.info(String.format("%s leave this house", name));
            house.removeRole(role);
            lock.notifyAll();
        }
    }
}
