package school.faang.bjs2_61502;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    private final String name;
    private Role assignedRole;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        this.assignedRole = house.assignRole();
        log.info("{} joined as {}", name, assignedRole);
    }

    public void leaveHouse(House house) {
        if (assignedRole != null) {
            house.releaseRole(assignedRole);
            log.info("{} left the role {}", name, assignedRole);
            assignedRole = null;
        }
    }
}