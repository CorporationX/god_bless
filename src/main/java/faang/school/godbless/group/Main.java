package faang.school.godbless.group;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("1", 18, "Google", "Amsterdam"),
                new User("2", 18, "Google", "Amsterdam"),
                new User("3", 19, "Google", "Amsterdam"),
                new User("4", 19, "Google", "Amsterdam"),
                new User("5", 20, "Google", "Amsterdam"),
                new User("6", 20, "Google", "Amsterdam")
        ));
        Map<Integer, List<User>> map = User.groupUsers(users);//проверка через дебаг
    }
}
