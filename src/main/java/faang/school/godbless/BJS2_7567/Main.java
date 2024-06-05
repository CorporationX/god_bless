package faang.school.godbless.BJS2_7567;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Lula", 24, "Amazon", "Baker st. 24");
        User user2 = new User("Oleg", 42, "Google", "Baker st. 24");
        User user3 = new User("Kate", 35, "Amazon", "Baker st. 24");
        User user4 = new User("Burak", 35, "Amazon", "Baker st. 24");
        User user5 = new User("Garry", 21, "Google", "Baker st. 24");
        User user6 = new User("Flash", 25, "Google", "Baker st. 24");
        User user7 = new User("Britney", 25, "Google", "Baker st. 24");
        User user8 = new User("Ola", 42, "Apple", "Baker st. 24");
        User user9 = new User("Lolo", 24, "Apple", "Baker st. 24");
        User user10 = new User("Sai", 24, "Apple", "Baker st. 24");

        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);

        for (var entry: User.groupUsers(users).entrySet()) {
            System.out.println(entry);
        }
    }
}