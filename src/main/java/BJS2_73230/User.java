package BJS2_73230;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class User {
    private final String name;
    private volatile String assignedRole;

    private static final Object lock = new Object();

    public User(String name) {
        this.name = name;
    }

    @SneakyThrows
    public  void joinHouse(House house) {
        synchronized (lock) {
            Optional<String> freeRole;

            while ((freeRole = house.takeFreeRole()).isEmpty()) {
                lock.wait();
            }

            this.assignedRole = freeRole.get();
            log.info("Joined house: {}, {}", this.name, this.assignedRole);
        }
    }

    public void leaveHouse(House house) {
        synchronized (lock) {
            house.releaseRole(this.assignedRole);
            log.info("Leaved house: {}, {}", this.name, this.assignedRole);
            this.assignedRole = null;
            lock.notifyAll(); // Уведомляем всех ожидающих
        }
    }
}
