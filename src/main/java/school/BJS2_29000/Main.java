package school.BJS2_29000;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        try {
            users.add(new User("Рома", "Amsterdam", "Google", 18));
            users.add(new User("Катя", "Amsterdam", "Google", 25));
            users.add(new User("Денис", "New York", "Uber", 27));
            users.add(new User("Вика", "London", "Google", 15));
            users.add(new User("Соня", "London", "Amazon", 28));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            if (entry.getKey() == 27) {
                System.out.println(entry.getValue());
            }
        }
    }
}
