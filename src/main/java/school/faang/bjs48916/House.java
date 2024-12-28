package school.faang.bjs48916;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
public class House {
    public static final long GOVERNANCE_PERIOD = 3_000;

    public final Object queue;
    private final Map<Role, Object> roleLockMap;
    private final List<Role> availableRoles;
    private final Map<Role, User> currentRoles;
    private final ScheduledExecutorService periodManager;

    public House() {
        availableRoles = new ArrayList<>(List.of(Role.values()));
        queue = new Object();
        currentRoles = new HashMap<>();
        periodManager = Executors.newScheduledThreadPool(Role.values().length);
        roleLockMap = Arrays.stream(Role.values())
                .collect(Collectors.toMap(
                        role -> role,
                        role -> new Object()
                ));
    }

    public void disband() {
        periodManager.shutdown();
    }

    public Optional<Role> addRole(User user) {
        Optional<Role> roleOptional = availableRoles.stream().findAny();
        Role role;
        if (roleOptional.isPresent()) {
            role = roleOptional.get();
            synchronized (roleLockMap.get(role)) {
                if (availableRoles.contains(role)) {
                    availableRoles.remove(role);
                    currentRoles.put(role, user);
                    periodManager.schedule(() -> removeRole(role), GOVERNANCE_PERIOD, TimeUnit.MILLISECONDS);
                    log.info("{} acquired role {}", user.getName(), role);
                    return Optional.of(role);
                } else {
                    return Optional.empty();
                }
            }
        } else {
            return Optional.empty();
        }
    }

    private void removeRole(Role role) {
        synchronized (roleLockMap.get(role)) {
            currentRoles.remove(role);
            availableRoles.add(role);
            synchronized (queue) {
                queue.notifyAll();
            }
            log.info("{} is now available", role);
        }
    }
}

