package school.faang.bjs2_81980;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class House {
    private List<String> roles = new ArrayList<>();

    public synchronized String assignRole() {
        try {
            while (roles.isEmpty()) {
                log.info("Нет доступных ролей. Ожидаем");
                wait();
            }
            return roles.remove(0);

        } catch (InterruptedException e) {
            log.error("Поток был прерван");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }
}
