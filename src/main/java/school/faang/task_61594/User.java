package school.faang.task_61594;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
public class User {
    private final String name;
    private String assignedRole = null;
    private House house = null;

    public void joinHouse(House house) {
        Objects.requireNonNull(house, "House cant be null!");
        synchronized (house) {
            assignedRole = house.assingRole();
            this.house = house;
            System.out.printf("Пользователь: %s получил роль: %s. В %s%n",
                    name, assignedRole, house.getName());
        }
    }

    public void leaveHouse() {
        Objects.requireNonNull(house, "House cant be null!");
        Objects.requireNonNull(assignedRole, "Role cant be null!");
        synchronized (house) {
            house.releaseRole(assignedRole);
            System.out.printf("Пользователь: %s покинул %s и освободил роль: %s%n",
                    name, house.getName(), assignedRole);
            assignedRole = null;
            house = null;
        }
    }
}
