package school.faang.bjs2_81987;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class User {
    private final long id;
    private String name;
    @Setter
    private RoleOfHouse role = RoleOfHouse.DEFAULT;

    public synchronized void joinHouse(House house) {
        while (role.equals(RoleOfHouse.DEFAULT)) {
            role = house.assignRole();
            if (!role.equals(RoleOfHouse.DEFAULT)) {
                break;
            }

            log.info("Пользователь {} ожидает роль...", name);
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка ожидания: {}", e.getMessage());
            }
        }
        log.info("Пользователь {} получил роль {}", name, role);
    }

    public void leaveHouse(House house) {
        house.releaseRole(role);
        log.info("Пользователь {} освободил роль {}", name, role);
        role = RoleOfHouse.DEFAULT;
        notifyAll();
    }
}
