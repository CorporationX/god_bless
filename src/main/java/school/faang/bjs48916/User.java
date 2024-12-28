package school.faang.bjs48916;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User {
    @Getter
    private final String name;
    private final House house;

    public User(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public void tryGetRole() {
        while (house.addRole(this).isEmpty()) {
            synchronized (house.queue) {
                try {
                    house.queue.wait();
                } catch (InterruptedException e) {
                    log.info("Error while {} was in queue to try to get role", name);
                }
            }
        }
    }
}
