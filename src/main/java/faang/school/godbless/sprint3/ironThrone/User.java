package faang.school.godbless.sprint3.ironThrone;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class User {
    private final String name;
    private final House house;
    private Role role;

    public void joinHouse() {
        synchronized (house) {
            while (house.getAvailableRoles() < 1) {
                System.out.printf("В доме %s нет свободных ролей, пользователь %s в ожидании%n", house.getName(), name);
                try {
                    house.wait();
                    System.out.printf("Пользователь %s вышел из ожидания%n", name);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            role = house.addRole();
            System.out.printf("Пользователь %s присоединился к дому %s%n", name, house.getName());
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            System.out.printf("Пользователь %s покинул дом %s%n", name, house.getName());
        }
        role = null;
    }
}
