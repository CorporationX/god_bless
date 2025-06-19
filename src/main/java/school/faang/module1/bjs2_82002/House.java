package school.faang.module1.bjs2_82002;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

@Slf4j
@AllArgsConstructor
public class House {

    private List<Role> availableRoles;
    private final Random random = new Random();

    public synchronized Role assignRole() {
        while (availableRoles.isEmpty()) {
            log.info("Нет доступных ролей. Ожидаем...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был прерван", e);
            }
        }
        return availableRoles.remove(generateRole());
    }

    public synchronized void releaseRole(Role role) {
        availableRoles.add(role);
        notify();
        log.info("Роль освобождена: {}", role);
    }

    private int generateRole() {
        return random.nextInt(availableRoles.size());
    }
}