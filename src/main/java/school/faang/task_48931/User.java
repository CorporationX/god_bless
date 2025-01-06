package school.faang.task_48931;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    private String name;
    private String joinHouse;
    private Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(@NonNull House house) {
        synchronized (house) {
            while (house.getCurrentAvailableRoles() == 0) {
                System.out.println(name + " стоит в очереди на присоединение.");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException("Ошибка ожидания", e);
                }
            }
            Role assignedRole = house.addPlayer();
            joinHouse = house.toString();
            role = assignedRole;
            System.out.println(name + " присоединился к дому, роль: " + role);
        }
    }

    public void leaveHouse(@NonNull House house) {
        synchronized (house) {
            if (role != null) {
                System.out.println(name + " освобождает роль: " + role);
                house.removePlayer(role);
                role = null;
                joinHouse = null;
            } else {
                System.out.println(name + " не состоит в доме.");
            }
        }
    }
}
