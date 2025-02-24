package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private String assignedRole;
    private House house;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            log.info(name + " выбрал роль " + assignedRole);
        }

    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                log.info(name + " покидает дом и освобождает роль: " + assignedRole);
                house.releaseRole(assignedRole);
                assignedRole = null;
                house = null;
            }

        }

    }

    public Thread startUserThread(House house) {
        Thread thread = new Thread(() -> {
            try {
                this.joinHouse(house);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                this.leaveHouse();
            }
        });
        thread.start();
        return thread;
    }
}
