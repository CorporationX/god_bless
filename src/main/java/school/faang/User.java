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
    private final String name;
    private String assignedRole;
    private House house;

    public void joinHouse(House house) {
        synchronized (house) {
            assignedRole = house.assignRole();
            this.house = house;
            System.out.println(name + " выбрал роль " + assignedRole);
        }

    }

    public void leaveHouse() {
        synchronized (house) {
            if (house != null && assignedRole != null) {
                System.out.println(name + " покидает дом и освобождает роль: " + assignedRole);
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
                Thread.sleep(1000); // Имитация времени, проведенного в доме
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
