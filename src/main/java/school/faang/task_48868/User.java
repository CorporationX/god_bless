package school.faang.task_48868;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Optional.*;

@Slf4j
@RequiredArgsConstructor
public class User {
    private final String name;
    private Optional<House> connectedHouse = empty();
    private Role selectedRole;

    public synchronized void joinHouse(@NonNull House house) {
        if (connectedHouse.isPresent()) {
            leaveHouse();
        }
        synchronized (house) {
            selectRole(house.getAvailableRoles());
            while (!house.getCurrentAvailableRoles().contains(selectedRole)) {
                try {
                    log.info("{} ждёт роль {} в доме {}", name, selectedRole, house);
                    house.wait();
                } catch (InterruptedException e) {
                    log.error("Ошибка ожидания роли: {}", e.getMessage());
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            log.info("{} подключился к {} с ролью {}", name, house, selectedRole);
            connectedHouse = of(house);
            house.reserveRole(selectedRole);
        }
    }

    public synchronized void leaveHouse() {
        if (connectedHouse.isEmpty()) {
            throw new IllegalStateException(name + " не подключен ни к одному дому");
        }
        synchronized (connectedHouse.get()) {
            log.info("{} покидает {}", name, connectedHouse.get());
            connectedHouse.get().releaseRole(selectedRole);
            connectedHouse = empty();
        }
    }

    private void selectRole(List<Role> availableRoles) {
        int randomIndex = ThreadLocalRandom.current().nextInt(availableRoles.size());
        selectedRole = availableRoles.get(randomIndex);
    }
}
