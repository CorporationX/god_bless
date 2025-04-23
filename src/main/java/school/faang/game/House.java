package school.faang.game;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class House {
    @Getter
    private final String name;
    private final Map<String, Boolean> rolesFree = new HashMap<>();
    private final Object lock = new Object();

    public House(String name, List<String> roles) {
        this.name = name;
        for (String role : roles) {
            rolesFree.put(role, true);
        }
    }

    public String assignRole() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                for (Map.Entry<String, Boolean> entry : rolesFree.entrySet()) {
                    if (entry.getValue()) {
                        String role = entry.getKey();
                        rolesFree.put(role, false);
                        return role;
                    }
                }
                log.info("Все роли в доме {} заняты. Ожидаем освобождение.", name);
                lock.wait();
            }
        }
    }

    public void releaseRole(String role) {
        synchronized (lock) {
            rolesFree.put(role, true);
            log.info("Роль {} в доме {} освобождена", role, name);
            lock.notifyAll();
        }
    }
}