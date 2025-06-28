package school.faang.bjs282270;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class House {
    @EqualsAndHashCode.Include
    @NonNull
    private final String name;

    @NonNull
    private final List<String> availableRoles;

    @Getter(AccessLevel.NONE)
    private final Map<String, User> occupiedRoles = new ConcurrentHashMap<>();

    public synchronized String assignRole(@NonNull User user) throws InterruptedException {
        while (true) {
            Optional<String> freeRole = availableRoles.stream()
                    .filter(role -> !occupiedRoles.containsKey(role))
                    .findFirst();

            if (freeRole.isPresent()) {
                String role = freeRole.get();
                occupiedRoles.put(role, user);
                log.info("{} занял роль {} в доме {}", user.getName(), role, name);
                return role;
            }

            log.info("{} ждёт свободной роли в доме {}", user.getName(), name);
            wait();
        }
    }

    public synchronized void releaseRole(@NonNull String role, @NonNull User user) {
        if (occupiedRoles.remove(role, user)) {
            log.info("{} покинул роль {} в доме {}", user.getName(), role, name);
            notifyAll();
        }
    }
}