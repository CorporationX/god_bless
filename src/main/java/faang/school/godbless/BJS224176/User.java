package faang.school.godbless.BJS224176;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private House house;

    public void joinHouse() throws InterruptedException {
        synchronized (house) {
            if (house.getFreeRoles() == 0) {
                house.wait();
            }
            house.addRole();
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            house.removeRole();
            house.notify();
        }
    }
}
