package faang.school.godbless;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        testAddConstructor();
        System.out.println();
        testGroupedUsers();
        System.out.println();
        testHobbyLovers();
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

    public static void testHobbyLovers() {
        Set<String> hobbies1 = new HashSet<>(List.of("Reading", "Dancing", "Coding"));
        Set<String> hobbies2 = new HashSet<>(List.of("Painting", "Gaming", "Cooking"));
        Set<String> hobbies3 = new HashSet<>(List.of("Traveling", "Music", "Sports"));

        User user1 = new User(1, "Alex", 25,"Uber", "New York", hobbies1);
        User user2 = new User(2, "Egor", 30,"Uber", "New York", hobbies2);
        User user3 = new User(3, "Dima", 28,"Uber", "New York", hobbies3);
        List<User> users = List.of(user1, user2, user3);

        Set<String> targetHobbies = new HashSet<>(List.of("Dancing", "Music", "Coding"));

        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, targetHobbies);
        for (User user : hobbyLovers.keySet()) {
            System.out.println(user + hobbyLovers.get(user));
        }
    }
}