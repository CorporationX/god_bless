package school.faang.ironthrone;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {

    private final List<RoleType> roles = new ArrayList<>(List.of(RoleType.KNIGHT, RoleType.MAGE, RoleType.LORD));

    public synchronized RoleType assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("Поток прерван во время ожидания ", e);
                Thread.currentThread().interrupt();
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(@NonNull RoleType role) {
        roles.add(role);
        notifyAll();
        log.info("Роль {} возвращена в лист доступных ролей", role);
    }
}
