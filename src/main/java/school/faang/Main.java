package school.faang;

import school.faang.bjs2_56312.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivan", 25, "Sber", "Moscow");
        User user3 = new User("Ira", 23, "Avito", "Novosibirsk");
        User user2 = new User("Roman", 25, "Yandex", "Moscow");
        User user4 = new User("Sasha", 24, "Sber", "Moscow");
        User user5 = new User("Max", 25, "Avito", "Novgorod");
        User user6 = new User("Daria", 24, "Megafon", "Moscow");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);
        Map<Integer, List<User>> userGroup = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : userGroup.entrySet()) {
            System.out.println("Age: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("  " + user);
            }
        }
    }
}
