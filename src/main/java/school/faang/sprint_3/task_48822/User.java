package school.faang.sprint_3.task_48822;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class User {
    private final String name;
    private House house;
    private String role;

    public void joinHouse(House house) {
        this.house = house;
        // не уверен в правильности данного кода, уже есть синхронизация в классе house,
        // но без синхронизации тут получается неправильный вывод
        synchronized (this.house) {
            this.role = house.addRole();
            System.out.println("User " + name + " joined house " + house + " with role " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole(role);
            System.out.println("User " + name + " left house " + house + " with role " + role);
        }
    }
}
