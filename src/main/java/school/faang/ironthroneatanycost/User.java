package school.faang.ironthroneatanycost;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class User {
    @NonNull
    private final String name;
    private String assignRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignRole = house.assignRole();
            this.house = house;
            log.info("{} выбрал роль: {}",
                    name, assignRole);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignRole != null) {
                log.info("{}  покидает дом и освобождает роль: {}",
                        name, assignRole);
                house.releaseRole(assignRole);
                assignRole = null;
                house = null;
            }
        }
    }
}
