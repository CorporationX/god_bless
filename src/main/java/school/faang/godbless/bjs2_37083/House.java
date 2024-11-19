package school.faang.godbless.bjs2_37083;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class House {
    private final Set<String> availableRoles = new HashSet<>();

    public House(List<String> roles) {
        availableRoles.addAll(roles);
    }

    public synchronized String removeRole() throws InterruptedException {
        while (availableRoles.isEmpty()) {
            log.info("Thread {} is waiting for available roles", Thread.currentThread().getName());
            wait();
        }
        String role = availableRoles.stream().limit(1).toList().get(0);
        availableRoles.remove(role);
        log.info("Role {} is taken", role);
        return role;
    }

    public synchronized void addRole(@NonNull String role) {
        if (role.isEmpty()) {
            log.error("Empty role is not allowed");
            return;
        }
        availableRoles.add(role);
        log.info("Role {} is available", role);
        notifyAll();
    }
}
