package school.faang.multithreading.sinchronized.bjs2_90309;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@EqualsAndHashCode
public class House {
    private Role role;
    private String name;

    public House(String name) {
        this.name = name;
    }

    public synchronized void assignRole(Role role) {
        while (role == this.role) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании роли: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        setRole(role);
    }

    public synchronized void releaseRole(Role role) {
        setRole(null);
        notify();
    }
}
