package school.faang.BJS2_37098_IronThrone;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class User {
    private String name;

    @Setter
    private House house;

    @Setter
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        leaveHouse();
        synchronized (house) {
            while (!house.isHasAvailableRoles()) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    log.error(
                            "Thread {} of user {} was interrupted when calling wait on House object",
                            name, Thread.currentThread().getName(),
                            e
                    );
                }
            }
            house.addRole(this);
        }
    }

    public void leaveHouse() {
        if (this.house != null) {
            synchronized (house) {
                house.removeRole(this);
                house.notify();
            }
        }
    }
}
