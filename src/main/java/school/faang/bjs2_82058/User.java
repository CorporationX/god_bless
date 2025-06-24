package school.faang.bjs2_82058;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User implements Runnable {
    private final String name;
    private final House house;
    private String assignedRole;

    public void joinHouse() {
        try {
            assignedRole = house.assignRole(name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("{} was interrupted while trying to join the house", name);
        }
    }

    public void leaveHouse() {
        house.releaseRole(name);
    }

    @Override
    public void run() {
        joinHouse();

        try {
            Thread.sleep((long) (1000 + Math.random() * 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("{} was interrupted during in-house activity", name);
        }

        leaveHouse();
    }
}
