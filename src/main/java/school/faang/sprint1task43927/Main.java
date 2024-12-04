package school.faang.sprint1task43927;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("testUser1", 22, "Google", "USA");
        User user2 = new User("testUser2", 33, "Uber", "Moscow");
        User user3 = new User("testUser3", 33, "Amazon1", "Dubai");
        User user4 = new User("testUser4", 44, "Amazon2", "Dubai");
        User user5 = new User("testUser5", 55, "Amazon3", "Dubai");
        User user6 = new User("testUser6", 44, "Amazon4", "Dubai");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        System.out.println(User.groupUsers(list));
    }
}
