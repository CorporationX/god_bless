package school.faang.sprint_1.task_bjs43999;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        Random randomAge = new Random();

        for (int i = 0; i < 10; i++) {
            userList.add(
                new User("Mixa", randomAge.nextInt(20, 24),
                    "Google",
                    "City"));
        }

        Map<Integer, List<User>> mapMain = User.groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry : mapMain.entrySet()) {
            System.out.println("\n Key= " + entry.getKey() + "/ values = " + entry.getValue());
        }
    }
}
