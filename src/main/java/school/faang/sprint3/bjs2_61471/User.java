package school.faang.sprint3.bjs2_61471;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class User {
    private final String name;
    private RolesType assignedRole;

    public User(String name) {
        this.name = name;
        this.assignedRole = null;
    }

    public void joinHouse(@NonNull House house) {
        assignedRole = house.assignRole();
        log.info(String.format("[%s] [%d] %s получена роль %s",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                Thread.currentThread().getId(),
                name,
                assignedRole
        ));
    }

    public void leaveHouse(@NonNull House house) {
        log.info(String.format("[%s] [%d] %s освободил роль %s",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                Thread.currentThread().getId(),
                name,
                assignedRole
        ));
        house.releaseRole(assignedRole);
        assignedRole = null;
    }
}
