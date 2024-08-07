package faang.school.godbless.collectUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>(Arrays.asList(
                new User(1L, "1", 1, new String[]{"1"}),
                new User(2L, "2", 2, new String[]{"2"}),
                new User(3L, "3", 3, new String[]{"3"}),
                new User(4L, "4", 4, new String[]{"1"}),
                new User(5L, "5", 5, new String[]{"2"}),
                new User(6L, "6", 6, new String[]{"3"}),
                new User(7L, "7", 7, new String[]{"1"}),
                new User(8L, "8", 8, new String[]{"2"})
        ));
        var map = User.findHobbyLovers(users,
                new HashSet<>(Arrays.asList("1", "3")));
    }
}
