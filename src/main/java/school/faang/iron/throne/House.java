package school.faang.iron.throne;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class House {
    private final Map<String, String> userNameToRole = new HashMap<>();
    private final Set<String> availableRoles = new HashSet<>();
    private int availableRolesCount;

    public House(List<String> availableRoles) {
        this.availableRoles.addAll(availableRoles);
        this.availableRolesCount = availableRoles.size();
    }

    public synchronized void addRole(String userName, String role) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("userName не может быть пустым");
        }
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("userName не может быть пустым");
        }
        availableRoles.remove(role);
        userNameToRole.put(userName, role);
        availableRolesCount--;
        System.out.println("Пользователь " + userName + " получил роль " + role);
    }

    public synchronized void removeRole(String userName) {
        String role = userNameToRole.remove(userName);
        availableRoles.add(role);
        availableRolesCount++;
        this.notify();
        System.out.println("Пользователь " + userName + " отдал роль " + role);
    }

    public synchronized List<String> getAvailableRoles() {
        while (!hasAvailableRoles()) {
            System.out.println("Нет доступных ролей");
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
        return new ArrayList<>(availableRoles);
    }

    public synchronized boolean hasAvailableRoles() {
        return availableRolesCount > 0;
    }
}
