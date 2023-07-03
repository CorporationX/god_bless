package faang.school.godbless.sprint_3.multithreading.iron_throne;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.Random;

@Getter
public class User {
    private final String NAME;
    private final House HOUSE;
    private String role;

    public User(String name, House house) {
        this.NAME = name;
        this.HOUSE = house;
    }

    @SneakyThrows
    public void joinHouse() {
        synchronized (HOUSE) {
            while (HOUSE.getFreeRolesCount() <= 0) {
                System.out.println("Нету свободных ролей в доме");
                HOUSE.wait();
            }
            int random = HOUSE.getFreeRolesList().size();
            int chose = new Random().nextInt(random);
            role = HOUSE.addRole(chose);
            System.out.printf("%s присоединяется к дому%n", NAME);
        }
    }

    public void leaveHouse() {
        synchronized (HOUSE) {
            System.out.printf("%s покидает дом.%n", NAME);
            HOUSE.removeRole(role);
        }
    }
}
