package faang.school.godbless.synchronization.task_6.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class House {
    @Getter
    private final String name;
    private final Map<Role, Integer> availableRoles;


    public House(String name) {
        this.name = name;
        availableRoles = new ConcurrentHashMap<>();
        availableRoles.put(Role.COIN_MASTER, 1);
        availableRoles.put(Role.KNIGHT, 1);
        availableRoles.put(Role.LORD, 1);
        availableRoles.put(Role.HEALER, 1);
        availableRoles.put(Role.MAGE, 1);
    }

    public synchronized Role assignRole() {
        Optional<Role> availableRole = getAvailableRole();
        if (availableRole.isEmpty()) {
            try {
                this.wait();
                return assignRole();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        } else {
            availableRoles.computeIfPresent(availableRole.get(), (roleKey, number) -> number - 1);
            return availableRole.get();
        }
        return availableRole.get();
    }

    public synchronized void makeRoleVacant(Role role) {
        availableRoles.computeIfPresent(role, (roleKey, number) -> number + 1);
        this.notifyAll();
    }

    private synchronized Optional<Role> getAvailableRole() {
        return availableRoles.entrySet().stream()
                .filter(availableRole -> availableRole.getValue() != 0)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}