package school.faang.sprint3.task_48906;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@ToString
public class User {
    private final String name;
    private Optional<House> house = Optional.empty();
    private Optional<Role> role = Optional.empty();

    public void joinHouse(House selectedHouse, Role selectedRole) {
        synchronized (selectedHouse) {
            while (!selectedHouse.isRoleAvailable(selectedRole)) {
                log.info("Role not available. Waiting: " + selectedHouse + " | " + selectedRole);
                try {
                    selectedHouse.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.warn("Thread interrupted while waiting to join house: "
                            + selectedHouse + " | " + selectedRole, e);
                    return;
                }
            }

            selectedHouse.takeRole(selectedRole);
            house = Optional.of(selectedHouse);
            role = Optional.of(selectedRole);
            log.info("Successfully joined house: " + selectedHouse + " with role: " + selectedRole);
        }
    }

    public void leaveHouse() {
        if (house.isPresent() && role.isPresent()) {
            House currentHouse = house.get();
            Role currentRole = role.get();

            synchronized (currentHouse) {
                currentHouse.freeRole(currentRole);
                house = Optional.empty();
                role = Optional.empty();
                currentHouse.notifyAll();
            }

            log.info("Successfully left house: " + currentHouse);
        } else {
            log.warn("You haven't been assigned a house or role.");
        }
    }

}
