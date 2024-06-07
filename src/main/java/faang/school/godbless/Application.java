package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j

public class Application {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        try {
            User user1 = new User("Vlad", 18, "Google", "London");
            User user2 = new User("Gleb", 22, "Amazon", "New York");
            User user3 = new User("Zlata", 32, "Uber", "Amsterdam");
            User user4 = new User("Varvara", 18, "Google", "London");
            User user5 = new User("Nikolas", 24, "Uber", "Amsterdam");
            User user6 = new User("Mathew", 22, "Google", "London");
            User user7 = new User("Jennifer", 18, "Uber", "Amsterdam");
            User user8 = new User("Andrew", 30, "Google", "New York");
            User user9 = new User("Alice", 35, "Uber", "Amsterdam");
            User user10 = new User("Jane", 35, "Amazon", "New York");
            User user11 = new User("Merry", 24, "Amazon", "New York");
            User user12 = new User("Lisa", 30, "Google", "London");
            User user13 = new User("Arnold", 27, "Amazon", "London");
            User user14 = new User("Gwen", 18, "Amazon", "New York");
            User user15 = new User("Michael", 35, "Uber", "London");

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
            users.add(user11);
            users.add(user12);
            users.add(user13);
            users.add(user14);
            users.add(user15);
            Map<Integer, List<User>> groupedUsers = User.groupUsers(users);
            System.out.println(groupedUsers);
        } catch (IllegalArgumentException e) {
            log.warn("Wrong initialization of a User" + e);
        }
    }
}