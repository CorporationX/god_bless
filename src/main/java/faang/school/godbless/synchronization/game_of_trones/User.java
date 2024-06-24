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

    public synchronized void joinHouse() throws InterruptedException {

        if (house.getCountActiveRole() == 0) {
            lock.wait();
        }
        house.addRole(role);
        log.info(String.format("%s join house with role:%s", name, role.name()));
    }

    public synchronized void leaveHouse() {
        synchronized (lock) {
            if (house.getMaxCountRole() != 0) {
                house.removeRole(role);
                log.info(String.format("%s leave this house", name));
                lock.notifyAll();
            }
        }

    }
}
