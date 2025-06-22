package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private House house;
    private final String name;
    private String assignedRole;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house, String role) {
        this.house = house;
        assignedRole = house.assignRole(role);
        log.info("Игрок {} присоединился к дому {} и получил роль {}", this.name, house.getHouseName(), assignedRole);
    }

    public synchronized void leaveHouse() {
        house.releaseRole(assignedRole);
        log.info("Игрок {} освободил роль {}", this.name, assignedRole);
        house = null;
        assignedRole = null;
    }
}