package school.faang.bjs2_90530;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User implements Runnable {
    private final String name;
    private String assignedRole;
    private House currentHouse;

    @Override
    public void run() {
        try {
            joinHouse(currentHouse);
            Thread.sleep(1000);
            leaveHouse();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoles().isEmpty()) {
                System.out.printf("Пользователь %s ждёт свободную роль в доме%n", name);
                house.wait();
            }

            String roleToAssign = house.getAvailableRoles().get(0);
            boolean success = house.assignRole(roleToAssign);
            if (success) {
                assignedRole = roleToAssign;
                currentHouse = house;
                System.out.printf("Пользователь %s присоединился к дому с ролью: %s%n", name, assignedRole);
            }
        }
    }

    public void leaveHouse() {
        if (currentHouse == null || assignedRole == null) {
            System.out.printf("Пользователь %s не состоит в доме, чтобы покинуть его%n", name);
            return;
        }

        synchronized (currentHouse) {
            boolean released = currentHouse.releaseRole(assignedRole);
            if (released) {
                System.out.printf("Пользователь %s покинул дом и освободил роль %s%n", name, assignedRole);
                assignedRole = null;
                currentHouse.notifyAll();
                currentHouse = null;
            }
        }
    }
}

