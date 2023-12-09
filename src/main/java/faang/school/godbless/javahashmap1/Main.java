package faang.school.godbless.javahashmap1;

import faang.school.godbless.javahashmap1.User;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "Alice", 25, new HashSet<>(Arrays.asList("Reading", "Sports")));
        User user2 = new User(2, "Bob", 30, new HashSet<>(Arrays.asList("Music", "Sports")));
        User user3 = new User(3, "Charlie", 22, new HashSet<>(Arrays.asList("Gaming", "Travel")));

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Set<String> targetActivities = Set.of("Reading", "Music");

        print(User.findHobbyLovers(userList, targetActivities));

    }

    public static void print(Map<User, String> hobbyLovers) {
        System.out.println("Отфильтрованные хобби:");
        hobbyLovers.forEach((user, hobby) -> System.out.println("Пользователь: " + user.getName()
                + "  Хобби: " + hobby));
    }
}
