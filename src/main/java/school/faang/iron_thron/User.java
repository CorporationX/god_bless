package school.faang.iron_thron;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private final String name;
    @Setter
    private String assignRole = "";

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        this.assignRole = house.assignRole(name);
        log.info("{} присоединился к дому. Его роль -{}", name, assignRole);
    }

    public void leaveHouse(House house){
        if (house!=null && !"".equals(assignRole)){
            log.info("{} вышел из дома", name);
            house.releaseRole(this);
        }
    }
}
