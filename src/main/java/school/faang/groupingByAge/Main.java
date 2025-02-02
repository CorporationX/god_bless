package school.faang.groupingByAge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 1984, 6, 12, "JavaDew", "asdfghjkl"));
        users.add(new User("Kate", 1985, 6, 12, "JavaDew", "asdfghjkl"));
        users.add(new User("Ivan", 1984, 6, 12, "JavaDew", "asdfghjkl"));
        users.add(new User("Lisa", 1986, 6, 12, "JavaDew", "asdfghjkl"));

        System.out.println(User.groupUsers(users, 39));
    }
}
