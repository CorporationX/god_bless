package school.faang.multithreading.synchronize.bjs2_92466;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {

    @Getter
    private String name;
    private String assignedRole;
    private House joinedHouse;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        joinedHouse = house;
        assignedRole = house.assignRole();
        log.info("Пользователю {} присвоена роль {}", name, assignedRole);
    }

    public void leaveHouse() {
        joinedHouse.releaseRole(assignedRole);
        log.info("Пользователь {} освободил роль {}", name, assignedRole);
    }
}