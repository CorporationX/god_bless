package school.faang.iron_throne_at_any_cost;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class User {
    private final String name;
    @Setter
    private House house;
    @Setter
    private Role role;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public synchronized void joinHouse(House house) throws InterruptedException {
        house.assignRoleToUser(this);
    }

    public synchronized void leaveHouse(House house) {
        house.removeRoleFromUser(this);
    }
}