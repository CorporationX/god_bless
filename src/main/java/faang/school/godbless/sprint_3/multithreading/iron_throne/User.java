package faang.school.godbless.sprint_3.multithreading.iron_throne;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class User {
    private String name;
    private final House house;
    private String role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    @SneakyThrows
    public void joinHouse() {
        synchronized (house) {
            List<String> freeRoles = house.getFreeRolesList();
            if (house.getFreeRolesCount() > 0) {
                int chose = new Random().nextInt(freeRoles.size());
                role = freeRoles.get(chose);
                freeRoles.remove(role);
                house.addRole();
                System.out.printf("%s присоединяется к дому%n", name);
            } else {
                System.out.println("Нету свободных ролей в доме");
                house.wait();
                int chose = new Random().nextInt(freeRoles.size());
                role = freeRoles.get(chose);
                freeRoles.remove(role);
                house.addRole();
                System.out.printf("%s присоединяется к дому%n", name);
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.printf("%s покидает дом.%n", name);
            house.getFreeRolesList().add(role);
            house.removeRole();
        }
    }
}
