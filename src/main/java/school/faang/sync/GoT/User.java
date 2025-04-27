package school.faang.sync.GoT;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class User {
    private final String name;
    private final HouseRoles role;
    private final House houseToJoin;

    public void joinHouse() throws InterruptedException {
        houseToJoin.assignRole(role.name());
        log.info("{} joined house with a role of {}", name, role);
    }

    public void leaveHouse() {
        houseToJoin.releaseRole(role);
        log.info("{} left house releasing a role of {}", name, role);
    }

}
