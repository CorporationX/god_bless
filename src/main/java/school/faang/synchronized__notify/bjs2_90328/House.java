package school.faang.synchronized__notify.bjs2_90328;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import static school.faang.synchronized__notify.bjs2_90328.Utils.runWithThreadErrorHandling;

@Slf4j
public class House {
    public final Queue<String> roles = new ArrayDeque<>(List.of(
            "Леди дома",
            "Лорд дома",
            "Десница Короля",
            "Рыцарь Королевской гвардии",
            "Мастер над монетой",
            "Мастер шептунов",
            "Мейстер",
            "Страж Ночного дозора",
            "Красная жрица",
            "Безликий",
            "Кхал"
    ));
    private final Object lock = new Object();

    public String assignRole() {
        synchronized (this.lock) {
            runWithThreadErrorHandling(() -> {
                if (roles.isEmpty()) {
                    log.info("Список ролей пуст, поток ждет");
                    lock.wait();
                    log.info("В списке появились роли, поток продолжил работу");
                }
            });
            return roles.poll();
        }

    }

    public void releaseRole(@NonNull String role) {
        synchronized (lock) {
            if (!roles.contains(role)) {
                roles.add(role);
            }
            lock.notify();
        }
    }
}