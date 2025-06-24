package school.faang.bjs2_81987;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class User {
    private final long id;
    private final String name;
    @Setter
    private RoleOfHouse role = RoleOfHouse.DEFAULT;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            this.house = house;
            role = house.tryAssignRole();
            log.info("Пользователь {} получил роль {}", name, role);
        }
    }

    public void leaveHouse(House house) {
        synchronized (house) {
            if (!role.equals(RoleOfHouse.DEFAULT)) {
                house.releaseRole(role);
                log.info("Пользователь {} освободил роль {}", name, role);
                role = RoleOfHouse.DEFAULT;
                house.notifyAll();
            }
        }
    }
}
