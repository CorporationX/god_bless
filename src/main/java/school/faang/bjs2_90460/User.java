package school.faang.bjs2_90460;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private String name;
    private String assignRole;

    public User(String name) {
        this.name = name;
    }

    public synchronized void joinHouse(House house) {
        this.assignRole = house.assignRole();
    }

    public synchronized void leaveHouse(House house, User user) {
        house.releaseRole(user);
    }

}
