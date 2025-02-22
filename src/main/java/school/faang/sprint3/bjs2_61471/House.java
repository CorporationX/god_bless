package school.faang.sprint3.bjs2_61471;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<RolesType> rolesTypes = new ArrayList<>(
            List.of(RolesType.KNIGHT, RolesType.MAGE, RolesType.KING, RolesType.LORD, RolesType.RENEGADE));

    public synchronized RolesType assignRole() {
        while (rolesTypes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error(String.format("[%s] [%d] Поток был прерван во время ожидания роли: %s.%n",
                        LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        Thread.currentThread().getId(),
                        e.getMessage()));
                Thread.currentThread().interrupt();
            }
        }
        return rolesTypes.remove(0);
    }

    public synchronized void releaseRole(@NonNull RolesType role) {
        rolesTypes.add(role);
        notifyAll();
        log.info(String.format("[%s] [%d] Роль %s доступна",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                Thread.currentThread().getId(),
                role
        ));
    }
}
