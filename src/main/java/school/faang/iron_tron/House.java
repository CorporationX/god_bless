package school.faang.iron_tron;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    public List<String> roles = new ArrayList<>(List.of("Страж дозора", "Лорд", "Рыцарь", "Ворон"));

    public synchronized void assignRole(User user, String role) {
        while (true) {
            if (!roles.isEmpty() && roles.contains(role)) {
                user.setAssignedRole(role);
                roles.remove(role);
                break;
            } else {
                try {
                    log.info(" {} ожидает своей роли", user.getName());
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void releaseRole(User user) {
        roles.add(user.getAssignedRole());
        notifyAll();
    }

}
