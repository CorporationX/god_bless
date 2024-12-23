package school.faang.task_48905;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class House {

    private final List<Role> availableRole;
    private final String name;
    private int availableRolesCount;

    public House(List<Role> availableRole, String name) {
        if (name == null || name.isEmpty()) {
            log.error("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (availableRole == null) {
            log.error("AvailableRole is null");
            throw new IllegalArgumentException("AvailableRole is null");
        }
        this.availableRole = new ArrayList<>(availableRole);
        this.name = name;
        this.availableRolesCount = availableRole.size();
    }

    public synchronized int getNumberOfAvailableRoles() {
        return availableRolesCount;
    }

    public synchronized void addRole(Role role) {
        availableRole.add(role);
        availableRolesCount++;
        log.info("Роль {} освобождена. Доступно ролей: {} ", role, availableRolesCount);
        notifyAll();
    }

    public synchronized Role removeRole() {
        if (availableRole.isEmpty()) {
            log.error("Нет доступных ролей");
            throw new IllegalStateException("Нет доступных ролей");
        }
        Role role = availableRole.remove(0);
        availableRolesCount--;
        log.info("Роль {} занята. Осталось ролей: {} ", role, availableRolesCount);
        return role;
    }
}