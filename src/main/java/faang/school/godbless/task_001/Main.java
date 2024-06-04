package faang.school.godbless.task_001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = 10;
        List<User> users = createListUsers(count);

        Map<Integer, List<User>> groupUsers = User.groupUsers(users);
        printMap(groupUsers);

    }

    private static void printMap(Map<Integer, List<User>> groupUsers) {
        for (var entry : groupUsers.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static List<User> createListUsers(int count) {
        List<User> users = new ArrayList<>();
        Random rand = new Random();

        for (int i = 1; i <= count; i++) {
            users.add(new User(
                    "User" + i,
                    rand.nextInt(12, 18),
                    "work" + i,
                    "address" + i)
            );
        }

        return users;
    }
}
