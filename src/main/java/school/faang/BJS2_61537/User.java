package school.faang.BJS2_61537;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@RequiredArgsConstructor
@Slf4j
public class User {

    private final String name;
    private House house;
    private String assignedRole;

    public void joinHouse(House house) {
        setHouse(house);
        setAssignedRole(house.assignRole());
        log.info("Игрок {} получил роль {}!", getName(), getAssignedRole());
    }

    public void leaveHouse() {
        if (assignedRole != null) {
            log.info("Игрок {} освобождается от роли {}!", getName(), getAssignedRole());
            house.releaseRole(assignedRole);
            setAssignedRole(null);
            setHouse(null);
        }
    }
}
