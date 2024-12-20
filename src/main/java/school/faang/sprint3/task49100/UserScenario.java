package school.faang.sprint3.task49100;

import lombok.AllArgsConstructor;
import school.faang.sprint3.task49100.model.House;
import school.faang.sprint3.task49100.model.User;

@AllArgsConstructor
public class UserScenario implements Runnable {
    private static final int TIME_TO_SERVE_SEC = 15;
    User user;
    House house;

    public void run() {
        user.joinHouse(house);

        try {
            Thread.sleep(TIME_TO_SERVE_SEC * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        user.leaveHouse();
    }

}
