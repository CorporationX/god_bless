package school.faang.task_48879;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@RequiredArgsConstructor
public class User {
    private final String name;
    private House house;
    private Role role;

    public void joinHouse(House house) {
        Role role = house.removeRole();
        this.role = role;
        this.house = house;

        log.info("Игрок {} присоединился к дому {} с ролью {}", name, house.getName(), role);
    }

    public void leaveHouse() {
        house.addRole(role);

        log.info("Игрок {} покинул дом {} и роль {}", name, house.getName(), role);
        house = null;
        role = null;
    }
}
