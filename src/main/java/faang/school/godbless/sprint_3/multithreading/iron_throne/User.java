package faang.school.godbless.sprint_3.multithreading.iron_throne;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
public class User {
    private final String name;
    private final House house;
    private String role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @SneakyThrows
    public void joinHouse() {
        synchronized (house) {
            while (house.getFreeRolesCount() <= 0) {
                System.out.println("Нету свободных ролей в доме");
                house.wait();
            }
            int random = house.getFreeRolesList().size();
            int chose = new Random().nextInt(random);
            role = house.addRole(chose);
            System.out.printf("%s присоединяется к дому%n", name);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.printf("%s покидает дом.%n", name);
            house.removeRole(role);
        }
    }
}
