package school.faang.iron_thron;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class House {
    private final List<String> roles = new ArrayList<>(List.of("Papa", "Mama", "Son", "Daughter"));
    private final Object lock = new Object();

    public String assignRole(String name) throws InterruptedException {
        synchronized (lock) {
            while (roles.isEmpty()) {
                log.info("{} роль для тебя занята, ждем", name);
                lock.wait();
            }
            return roles.remove(new Random().nextInt(roles.size()));
        }
    }

    public void releaseRole(User user) {
        synchronized (lock) {
            roles.add(user.getAssignRole());
            user.setAssignRole("");
            lock.notifyAll();
        }
    }
}
