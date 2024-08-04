package faang.school.godbless;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        User user1 = new User("1", "Stanly", 20, "Apple", "CA");
        User user2 = new User("2", "Tom", 30, "Google", "WA");
        User user3 = new User("3", "Sam", 40, "Facebook", "SA");
        User user4 = new User("4", "Tim", 40, "Netflix", "WA");

        Map<Integer, List<User>> test = User.groupUsers(
                List.of(user1, user2, user3, user4)
        );

        test.forEach(
                (age, users) -> users.forEach(
                        user -> System.out.println(age + " = " + user.getName())
                )
        );
    }
}