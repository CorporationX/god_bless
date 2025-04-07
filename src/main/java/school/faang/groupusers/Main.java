package school.faang.groupusers;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Pavel", 30, "Amazon", "Pushkin 29");
        User user2 = new User("Kateryna", 25, "Uber", "Pushkin 29");
        User user3 = new User("Vlad", 26, "Kaspi", "Pushkin 29");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        System.out.println(User.getUsersWithAge(users, 25));


    }
}
