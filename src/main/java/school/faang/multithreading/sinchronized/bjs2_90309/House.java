package school.faang.multithreading.sinchronized.bjs2_90309;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Slf4j
@EqualsAndHashCode
public class House {
    private final List<Role> roles = new ArrayList<>(List.of(Role.values()));
    private final String name;

    public House(String name) {
        this.name = name;
    }

    public synchronized Role assignRole(Role role) {
        while (!roles.contains(role)) {
            try {
                // log.info("ожидаем пока освободится роль {}", role); // проверка на ожидание в цикле
                wait();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании роли: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        int index = IntStream.range(0, roles.size())
                .filter(i -> roles.get(i).equals(role))
                .findFirst().orElse(-1);
        return (index != -1) ? roles.remove(index) : null;
    }

    public synchronized void releaseRole(Role role) {
        roles.add(role);
        notify();
    }
}
