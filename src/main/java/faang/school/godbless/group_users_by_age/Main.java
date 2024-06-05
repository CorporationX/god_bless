package faang.school.godbless.group_users_by_age;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("George", 21, "Google", "New York");
        User user2 = new User("Ethan", 22, "Amazon", "London");
        User user3 = new User("Someone else", 21, "OPS", "Yonge St. 5775");

        try {
            User nameNullThrow = new User(null, 21, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User nameEmptyThrow = new User("", 21, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User ageThrow = new User("George", 17, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User companyNameThrow = new User("George", 21, "OPS", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User nameNullThrow = new User("George", 21, "Google", "Toronto");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Map<Integer, List<User>> map = User.groupUsers(Arrays.asList(user2, user1, user3));

        System.out.println(map);
        System.out.println(map.get(21));
    }
}