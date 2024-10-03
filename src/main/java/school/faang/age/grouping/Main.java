package school.faang.age.grouping;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Nikola", 21, "Ya.Eats", "Lermontova str.");
        User user2 = new User("Nikita", 21, "Ya.Eats", "Grushevskaya str.");
        User user3 = new User("Georgy", 22, "Ya.Eats", "Sevastopolskaya str.");
        User user4 = new User("Alisa", 22, "Ya.Eats", "Lermontova str.");
        User user5 = new User("Maksim", 30, "Ya.Eats", "Lermontova str.");

        Map<Integer, List<User>> ageToUsers = User.groupUsers(List.of(user1, user2, user3, user4, user5));
        ageToUsers.forEach((key, val) -> System.out.println(key + ": " + val));
    }
}
