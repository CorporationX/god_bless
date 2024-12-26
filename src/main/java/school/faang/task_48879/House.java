package school.faang.task_48879;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Slf4j
public class House {
    @Getter
    private final String name;
    private final List<Role> availableRoles;
    private int currentAvailableRoles;

    public House(String name, List<Role> availableRoles) {
        this.name = name;
        this.availableRoles = new ArrayList<>(availableRoles);
        this.currentAvailableRoles = availableRoles.size();
    }

    public synchronized void addRole(Role role) {
        availableRoles.add(role);
        currentAvailableRoles++;
        notifyAll();
    }

    public synchronized Role removeRole() {
        while (availableRoles.isEmpty()) {
            try {
                log.info("Ожидание свободных ролей...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток был перерван при выполении метода wait()");
            }
        }
        Role availableRole = getAvailableRole();
        availableRoles.remove(availableRole);
        currentAvailableRoles--;
        return availableRole;
    }

    public synchronized int getCurrentAvailableRoles() {
        return currentAvailableRoles;
    }

    private Role getAvailableRole() {
        return availableRoles.stream().findFirst().orElseThrow();
    }
}
