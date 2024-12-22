package school.faang.task_48857;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private Optional<House> connectedHouse = Optional.empty();
    private Role selectedRole;

    public synchronized void joinHouse(@NonNull House house) {
        if (connectedHouse.isPresent()) {
            leaveHouse();
        }
        synchronized (house) {
            selectRole(house.getAvailableRoles());
            while (!house.getCurrentAvailableRoles().contains(selectedRole)) {
                try {
                    log.info("{} is waiting to be connected to the {} by role: {}", name, house, selectedRole);
                    house.wait();
                } catch (InterruptedException e) {
                    log.error("Interrupted while waiting for role: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            log.info("{} is connected to the {} by role: {}", name, house, selectedRole);
            connectedHouse = Optional.of(house);
            house.reserveRole(selectedRole);
        }
    }

    public synchronized void leaveHouse() {
        if (connectedHouse.isEmpty()) {
            throw new IllegalStateException(name + " is not connected to any house");
        }
        synchronized (connectedHouse.get()) {
            log.info("{} leave from {}", name, connectedHouse.get());
            connectedHouse.get().releaseRole(selectedRole);
            connectedHouse = Optional.empty();
        }
    }

    private void selectRole(List<Role> availableRoles) {
        int randomIndex = ThreadLocalRandom.current().nextInt(availableRoles.size());
        selectedRole = availableRoles.get(randomIndex);
    }
}
