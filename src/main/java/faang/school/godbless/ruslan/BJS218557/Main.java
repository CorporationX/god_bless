package faang.school.godbless.ruslan.BJS218557;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Ruslan", 25, "cdek", "sovetskay"));
        users.add(new User("Olga", 25, "cdek", "sovetskay"));
        users.add(new User("Darina", 16, "cdek", "sovetskay"));

        Map<Integer, List<User>> usersAge = User.groupUsers(users);
        usersAge.forEach((key,value) -> System.out.println(key + " " + value));
    }
}
