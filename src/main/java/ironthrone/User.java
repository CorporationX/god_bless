package ironthrone;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
@RequiredArgsConstructor
public class User {
    @NonNull
    private final String name;
    private House house;
    private HouseRole role;

    public void joinHouse(@NonNull House house) {
        this.house = house;
        synchronized (house) {
            if (house.isAnyRoleAvailable()) {
                setRole(house);
            } else {
                try {
                    log.info(String.format("Waiting for available role in house of %s...", house.getName()));
                    while (!house.isAnyRoleAvailable()) {
                        house.wait();
                    }
                    setRole(house);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void setRole(@NonNull House house) {
        var roles = house.getAvailableRoles();
        role = roles.get(ThreadLocalRandom.current().nextInt(roles.size()));
        house.addRole(role);
        log.info(String.format("%s joined house of %s as %s", name, house.getName(), role));
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            log.info(String.format("%s leave house of %s", name, house.getName()));
        }
        role = null;
        house = null;
    }
}
