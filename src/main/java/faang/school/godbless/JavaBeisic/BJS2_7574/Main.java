package faang.school.godbless.JavaBeisic.BJS2_7574;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user = new User("Lexa", 18, "Google", "Lenina 1");
        User user1 = new User("Dima", 18, "Yandex", "Pulino 1");
        User user2 = new User("Katya", 17, "Sberbank", "Gigino 1");
        User user3 = new User("Bobic", 21, "Aston", "Dmitrevo 1");
        User user4 = new User("Petyua", 21, "AlphaBank", "Bishembekovo 1");
        User user5 = new User("Sonya", 17, "Bank", "Malievo 1");
        User user6 = new User("Lelic", 17, "Gazprom", "Lilivo 1");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        Map<Integer, List<User>> groupedUsers = groupUsers(users);
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            int ageUsers = user.getAge();
            groupedUsers.putIfAbsent(ageUsers, new ArrayList<>());
            groupedUsers.get(ageUsers).add(user);
        }
        return groupedUsers;
    }
}
