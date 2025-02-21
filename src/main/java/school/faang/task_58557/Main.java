package school.faang.task_58557;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<User> users = new ArrayList<>();
    private static Map<User, Integer> indexMap = new HashMap<>();
    private static int index = 0;

    public static void main(String[] args) {
        User user1 = new User(17, "Lana", "school", "home1");
        add(user1);
        User user2 = new User(18, "Alan", "university", "home2");
        add(user2);
        User user3 = new User(19, "Nala", "university", "home3");
        add(user3);
        User user4 = new User(5, "Lee", "kindergarden", "home4");
        add(user4);
        User user5 = new User(5, "Jee", "kindergarden", "home4");
        add(user5);
        printAllStudents();
        remove(user1);
        printAllStudents();
        System.out.println(User.groupUsers(users));

    }

    public static void add(User user) {
        users.add(user);
        indexMap.put(user, index++);
    }

    public static void remove(User user) {
        users.remove(user);
    }

    public static void printAllStudents() {
        System.out.println("All users: ");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
