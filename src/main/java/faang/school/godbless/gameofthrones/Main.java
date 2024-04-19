package faang.school.godbless.gameofthrones;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        House house = new House();
        List<User> users = initialize(house);

        User testUser = new User("TestUser", house);
        Thread testThread = new Thread(() -> {
            testUser.joinHouse();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            testUser.leaveHouse();
        });

        testThread.start();

        for (User user : users) {
            new Thread(user::joinHouse).start();
        }
    }

    private static List<User> initialize(House house) {
        return List.of(
                new User("user_1", house),
                new User("user_2", house),
                new User("user_3", house),
                new User("user_4", house),
                new User("user_5", house),
                new User("user_6", house),
                new User("user_7", house),
                new User("user_8", house),
                new User("user_9", house),
                new User("user_10", house),
                new User("user_11", house),
                new User("user_12", house)
        );
    }
}
