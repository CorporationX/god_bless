package school.faang.bjs243980;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static final int AGE_27 = 27;
    public static final int AGE_25 = 25;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.addAll(createUsers(3, AGE_27));
        users.addAll(createUsers(3, AGE_25));

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
