package school.faang.task_48831;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data

public class User {
    private String name;
    private House house;
    private Role busyRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        synchronized (house) {
            Role desiredRole = house.getRoles().stream()
                    .filter(role -> role.getUser() == null)
                    .findAny()
                    .orElse(null);

            if (desiredRole == null) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    log.error("Ошибка выполнения кода: {}", String.valueOf(e));
                }
            } else {
                house.addRole(desiredRole, this);
            }
        }
    }

    public void leaveHouse(House house) {
        if (this.house == null || busyRole == null) {
            System.out.println("У пользователя нет дома или роли");
            return;
        }

        house.removeRole(busyRole, this);
    }
}
