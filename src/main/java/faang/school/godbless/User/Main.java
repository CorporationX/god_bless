package faang.school.godbless.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User user:users) {
            map.computeIfAbsent(user.getAge(), k -> new ArrayList<>())
                    .add(user);
        }
        return map;
    }

    private static void print(Map<Integer, List<User>> map) {
        for (Map.Entry<Integer, List<User>> entry : map.entrySet()) {
            System.out.println("\t\tвозраст " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("имя " + user.getName() + " место работы " + user.getPlaceOfWork() + " адресс " + user.getAddress());
            }
        }
    }

    public static void main(String[] args) {
        List<User> listUser = Arrays.asList(
                new User("Alice", 30, "Google", "123 Main St"),
                new User("Bob", 28, "Amazon", "456 Elm St"),
                new User("Charlie", 25, "Facebook", "789 Oak St"),
                new User("David", 40, "Microsoft", "101 Maple St"),
                new User("Eve", 25, "Apple", "202 Pine St"),
                new User("Frank", 35, "Netflix", "303 Birch St"),
                new User("Grace", 28, "Spotify", "404 Cedar St"),
                new User("Hank", 28, "Snapchat", "505 Walnut St"),
                new User("Ivy", 22, "Uber", "606 Pecan St"),
                new User("Olivia", 28, "Oracle", "1212 Pinecone St")
        );
        print(groupUsers(listUser));
    }
}
