package faang.school.godbless.group_user;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Pavel", 30, "Builder", "London");
        User user2 = new User("Andrei", 22, "Dev", "Moscow");
        User user3 = new User("Alina", 27, "Ingenere", "Omsk");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Map<Integer, List<User>> groupedUser = User.groupUser(users);
        List<User> users1 = groupedUser.get(30);
        System.out.println(users1.get(0).getFirstname());
    }
}
