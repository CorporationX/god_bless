package faang.school.godbless.GroupUsersByAge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User u1 = new User("Boba", 18, "teacher", "Serp");
        User u2 = new User("Biba", 13, "firefighter", "Msc");
        User u3 = new User("Beba", 18, "comic", "New York");
        User u4 = new User("Baba", 8, "worker", "Kirov");
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u3);
        users.add(u2);
        users.add(u4);
        System.out.println(User.groupUsers(users));
    }
}
