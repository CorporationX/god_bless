package school.faang.ironthron;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class House {
    private final List<String> roles;

    public House(List<String> roles) {
        this.roles = roles;
    }

    public synchronized void assignRole(User user) throws InterruptedException {
        while (roles.isEmpty()) {
            wait();
        }
        int countRole = (int) (Math.random() * roles.size());
        String role = roles.get(countRole);
        roles.remove(role);
        user.setAssignedRole(role);
        log.info("К дому присоединился {} и взял(а) роль {}", user.getName(), role);
    }

    public synchronized void releaseRole(User user) {
        String role = user.getAssignedRole();
        user.setAssignedRole(null);
        roles.add(role);
        log.info("Пользователь {} освободил роль {}", user.getName(), role);
        notifyAll();
    }
}