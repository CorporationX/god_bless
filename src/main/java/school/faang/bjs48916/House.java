package school.faang.bjs48916;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class House {
    public static final long GOVERNANCE_PERIOD = 2000;
    public static enum Role {
        LORD,
        ELDER,
        MAGE,
        KNIGHT
    }

    private volatile List<Role> availableRoles;
    private final Map<Role, User> currentRoles;
    ScheduledExecutorService periodManager = Executors.newScheduledThreadPool(Role.values().length);

    public House() {
        availableRoles = new ArrayList<>(List.of(Role.values()));
        currentRoles = new HashMap<>();
    }

    public List<Role> getAvailableRoles() {
        return List.copyOf(availableRoles);
    }

    public boolean joinHouse(User user, Role role) {
        synchronized (role) {
            if (availableRoles.contains(role)) {
                availableRoles.remove(role);
                currentRoles.put(role, user);
                periodManager.schedule(() -> kick(role), GOVERNANCE_PERIOD, TimeUnit.MILLISECONDS);
                return true;
            }
            else {
                return false;
            }
        }
    }

    private void kick(Role role) {
        synchronized (role) {
            currentRoles.get(role).leave();
            currentRoles.remove(role);
            availableRoles.add(role);
            log.info("{} is now available", role);
        }
    }
}

