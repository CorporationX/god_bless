package school.faang.bjs2_82044;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignRole;

    public void joinHouse(House house) {
        synchronized (house) {
            assignRole = house.assignRole();
            log.info("игрок {} взял роль {}", name, assignRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            if (house != null && assignRole != null) {
                house.releaseRole(assignRole);
                log.info("игрок {} покинул дом и освободил роль {}", name, assignRole);
            }
        }
    }
}
