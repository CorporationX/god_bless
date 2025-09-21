package school.faang.multithreading.sinchronized.bjs2_90309;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@EqualsAndHashCode
public class House {
    private final List<Role> roles = new ArrayList<>();
    private String name;

    public House(String name) {
        this.name = name;
    }

    public synchronized Role assignRole(Role role) {
        while (roles.isEmpty() || roles.contains(role)) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании роли: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        int index = 0;
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).equals(role)) {
                index = i;
            }
        }
        return roles.remove(index);
    }

    public synchronized void releaseRole(Role role) {
        roles.add(role);
        notify();
    }
}
