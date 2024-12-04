package school.faang.bjs243980;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.addAll(createUsers(3, 30));
        users.addAll(createUsers(2, 27));
        users.addAll(createUsers(5, 25));
        users.addAll(createUsers(3, 30));

        System.out.println(User.groupUsers(users));
    }

    public static List<User> createUsers(int count, int age) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User("Name", age, "Sber", "Moscow"));
        }
        return users;
    }
}
