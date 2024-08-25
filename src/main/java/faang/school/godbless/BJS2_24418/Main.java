package faang.school.godbless.BJS2_24418;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int USERS_COUNT = 20;
        UserList userList = new UserList(createUsers(USERS_COUNT));
    }

    public static List<User> createUsers(int usersCount) {
        return IntStream.range(0, usersCount)
                .mapToObj(i -> new User(i, "User_" + i))
                .toList();
    }
}
