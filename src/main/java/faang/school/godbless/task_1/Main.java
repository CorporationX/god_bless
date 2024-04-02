package faang.school.godbless.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Tema", 19, "company", "address");
        User user2 = new User("Nikita", 21, "company", "address");
        User user3 = new User("Dasha", 21, "company", "address");
        User user4 = new User("Danya", 19, "company", "address");
        User user5 = new User("Valera", 16, "company", "address");
        List<User> test = new ArrayList<>();
        test.add(user1);
        test.add(user2);
        test.add(user3);
        test.add(user4);
        test.add(user5);
        Map<Integer, List<User>> map = User.groupUsers(test);
        for (int age : map.keySet()) {
            StringBuilder builder = new StringBuilder();
            for (User user : map.get(age)) builder.append(user.getName()).append(" ");
            System.out.println(age + ": " + builder);
        }
    }
}
