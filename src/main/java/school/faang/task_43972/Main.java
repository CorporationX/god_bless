package school.faang.task_43972;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final int NUMBER_OF_USER = 10;

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        Map<Integer, String> result;

        for (int i = 0; i < NUMBER_OF_USER; i++) {
            User user = new User(i);
            userList.add(user);
        }

        for (int i = 0; i < NUMBER_OF_USER; i++) {
            System.out.println(userList.get(i));
        }

        result = User.findHobbyLovers(userList, Set.of("black", "yellow"));
        System.out.println(result);
    }
}
