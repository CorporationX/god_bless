package faang.school.godbless;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        testAddConstructor();
        testGroupedUsers();
    }

    public static void testGroupedUsers() {
        User user1 = new User("Alex", 21, "Facebook", "123 Main Street");
        User user2 = new User("Egor", 18, "Amazon", "456 Elm Street");
        User user3 = new User("Dima", 18, "Apple", "789 Oak Street");
        User user4 = new User("Vika", 21, "Netflix", "1011 Pine Street");

        List<User> users = List.of(user1, user2, user3, user4);

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        for (Integer age : groupedUsers.keySet()) {
            System.out.println("Возраст " + age + ":" + groupedUsers.get(age));
        }
    }

    public static void testAddConstructor() {
        User user1 = new User("Alex", 21, "Google", "Amsterdam");
        System.out.println("Пользователь " + user1 + " создан");

        try {
            User user2 = new User("  ", 18, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user3 = new User("Dima", 15, "Uber", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user4 = new User("Vika", 25, "Netflix", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user5 = new User("Egor", 20, "Google", "Moscow");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}