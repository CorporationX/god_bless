package faang.school.godbless.groupUsers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Kate", 27, "Sber", "Moscow");
        User user2 = new User("Mark", 18, "Yandex", "Saint Petersburg");
        User user3 = new User("Alice", 19, "Sber", "Moscow");
        User user4 = new User("Bob", 19, "Ozon", "Moscow");
        User user5 = new User("Tom", 27, "Yandex", "Novosibirsk");
        User user6 = new User("Mary", 27, "T-Bank", "Saint Petersburg");
        User user7 = new User("Julia", 20, "T-Bank", "Tomsk");
        User user8 = new User("Sam", 20, "Sber", "Novosibirsk");

        Map<Integer, List<User>> result = User.groupUsers(new LinkedList<>(Arrays.asList(
                user1, user2, user3, user4, user5, user6, user7, user8)));

        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
