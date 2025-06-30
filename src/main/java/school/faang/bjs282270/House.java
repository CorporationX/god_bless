package school.faang.bjs282270;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@AllArgsConstructor
@ToString(of = "name")
@EqualsAndHashCode(of = "name")
public class House {
    @NonNull
    private final String name;

    @NonNull
    private final List<String> availableRoles;
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