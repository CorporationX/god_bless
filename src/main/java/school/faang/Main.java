package school.faang;

import java.util.List;
import java.util.Map;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alex", 25, 1, "football music");
        User user2 = new User("Maria", 30, 2, "reading music");
        User user3 = new User("Ivan", 22, 3, "gaming chess");

        List<User> users = Arrays.asList(user1, user2, user3);

        List<String> activities = Arrays.asList("music");

        Map<String, String> lovers = User.findHobbyLovers(users, activities);

        System.out.println(lovers);
    }
}

