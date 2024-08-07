package faang.school.godbless.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("1", 1, "1", "1"),
                new User("2", 1, "2", "2"),
                new User("3", 2, "3", "3"),
                new User("4", 2, "4", "4"),
                new User("5", 3, "5", "5"),
                new User("6", 3, "6", "6")
        ));
        Map<Integer, List<User>> map = User.groupUsers(users);//проверка через дебаг
    }
}
