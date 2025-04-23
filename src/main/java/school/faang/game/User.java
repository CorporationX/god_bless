package school.faang.game;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class User {
    private final String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) throws InterruptedException {
        this.house = house;
        this.assignedRole = house.assignRole();
        log.info("{} присоединился к дому {} в качестве {}", name, house.getName(), assignedRole);
    }

    public void leaveHouse() {
        if (house != null && assignedRole != null) {
            house.releaseRole(assignedRole);
            log.info("{} покинул дом {}", name, house.getName());
            assignedRole = null;
            house = null;
        }
    }
}