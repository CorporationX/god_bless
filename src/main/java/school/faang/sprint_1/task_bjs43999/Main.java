package school.faang.sprint_1.task_bjs43999;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(
                new User("Mixa" + new Random().nextInt(100), new Random().nextInt(2),
                    "Google" + new Random().nextInt(100),
                    "City" + new Random().nextInt(100)));
        }

        Map<Integer, List<User>> mapMain = User.groupUsers(userList);
        for (var entry : mapMain.entrySet()) {
            System.out.println("\n Key= " + entry.getKey() + "/ values = " + entry.getValue());
        }
    }
}
