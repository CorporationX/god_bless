package school.faang.ironthrone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class User {
    private static final int TIME_AT_HOME = 3000;
    private String name;
    private String assignedRole;

    public void joinHouse(House house) {
        try {
            house.assignRole(assignedRole);
            log.info("{} вступил в дом", this.name);
            Thread.sleep(TIME_AT_HOME);
            leaveHouse(house);
        } catch (InterruptedException e) {
            log.error("Поток пользователя {} прерван", this.name);
            Thread.currentThread().interrupt();
        }
    }

    public void leaveHouse(House house) {
        house.releaseRole(assignedRole);
        log.info("{} покунул дом", this.name);
    }
}
