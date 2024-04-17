package faang.school.godbless.bjs2_5632;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@AllArgsConstructor
public class House {

    private String name;
    private final Map<Role, Integer> roles = new HashMap<>();

    public void addRole(Role role, User user) {
        synchronized (roles) {
            log.info("------------------- User {} enter to sync addRole block ------------------- ", user.getName());
            int countOfRole = roles.get(role);
            if (countOfRole <= 0) {
                log.info("The role {} is over. {} Wait until it's free.", role.getName(), user.getName());
                try {
                    roles.wait();
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
            }
            roles.computeIfPresent(role, (key, value) -> value - 1);
            user.setHouse(this);
            user.setRole(role);
            log.info("{} has role {} in house {}", user.getName(), role.getName(), name);
        }
    }

    public void removeRole(Role role, User user) {
        synchronized (roles) {
            roles.computeIfPresent(role, (key, value) -> value + 1);
            log.info("{} leave {}", user.getName(), user.getHouse().getName());
            log.info("The role of the {} is free", role.getName());
            user.setRole(new Role("no role"));
            user.setHouse(new House("no house"));
            roles.notify();
        }
    }
}
