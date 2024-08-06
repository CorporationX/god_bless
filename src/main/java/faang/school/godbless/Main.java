package faang.school.godbless;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        testAddConstructor();
        System.out.println();
        testGroupedUsers();
        System.out.println();
        testReverse();
    }

    public static void testGroupedUsers() {
        User user1 = new User("Alex", 21, "Google", "Amsterdam");
        User user2 = new User("Egor", 18, "Amazon", "London");
        User user3 = new User("Dima", 18, "Uber", "New York");
        User user4 = new User("Vika", 21, "Google", "London");

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

    public static void testReverse() {
        Example example = new Example();
        int[] arrayInt1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arrayInt1));
        arrayInt1 = example.reverse(arrayInt1);
        System.out.println(Arrays.toString(arrayInt1));
        System.out.println();

        int[] arrayInt2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arrayInt2));
        arrayInt2 = example.reverse(arrayInt2);
        System.out.println(Arrays.toString(arrayInt2));
        System.out.println();

        int[] arrayInt3 = {8};
        System.out.println(Arrays.toString(arrayInt3));
        arrayInt3 = example.reverse(arrayInt3);
        System.out.println(Arrays.toString(arrayInt3));
        System.out.println();

        int[] arrayInt4 = {8, 1};
        System.out.println(Arrays.toString(arrayInt4));
        arrayInt4 = example.reverse(arrayInt4);
        System.out.println(Arrays.toString(arrayInt4));
    }
}