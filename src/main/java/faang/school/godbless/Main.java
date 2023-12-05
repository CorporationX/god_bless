package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        //users.add(new User("Boris", 36, "Megafon", "Moskow"));
        users.add(new User("Mihail", 36, "Google", "New York"));
        users.add(new User("Oleg", 36, "Amazon", "London"));
        users.add(new User("Elena", 47, "Uber", "Amsterdam"));
        users.add(new User("Masha", 23, "Google", "Amsterdam"));
        //users.add(new User("Mila", 25, "MTS", "London"));
        //users.add(new User("Sergey", 32, "Google", "Paris"));

        User.groupUsers(users);

    }
}