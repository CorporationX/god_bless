package school.faang.iron.throne;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
public class House {
    private final Map<String, String> userNameToRole = new HashMap<>();
    private final List<String> availableRoles = new ArrayList<>();
    private int availableRolesCount;

    public House(List<String> availableRoles) {
        this.availableRoles.addAll(availableRoles);
        this.availableRolesCount = availableRoles.size();
    }

    public synchronized String addRole(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("userName не может быть пустым");
        }
        while (availableRolesCount <= 0) {
            System.out.println("Нет доступных ролей");
            try {
                this.wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        }
        Random random = new Random();
        int roleIndex = random.nextInt(availableRoles.size());
        String role = availableRoles.get(roleIndex);
        availableRoles.remove(roleIndex);
        userNameToRole.put(userName, role);
        availableRolesCount--;
        System.out.println("Пользователь " + userName + " получил роль " + role);
        return role;
    }

    public synchronized void removeRole(String userName) {
        String role = userNameToRole.remove(userName);
        availableRoles.add(role);
        availableRolesCount++;
        this.notify();
        System.out.println("Пользователь " + userName + " отдал роль " + role);
    }
}
