package faang.school.godbless.UserRegistration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User u1 = new User("Boba", 23, "Google", "New York");
        User u2 = new User("Biba", 18, "Uber", "Amsterdam");
        User u3 = new User("Beba", 28, "Amazon", "London");
        User u4 = new User("Baba", 18, "Amazon", "New York");
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u3);
        users.add(u2);
        users.add(u4);
        System.out.println(User.groupUsers(users));
    }
}