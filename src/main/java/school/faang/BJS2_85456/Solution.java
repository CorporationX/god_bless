package school.faang.BJS2_85456;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        User user1 = new User("Bob", 15, "School", "Sbp");
        User user2 = new User("John", 20, "ITMO", "Sbp");
        User user3 = new User("Petr", 20, "HSE", "Moscow");
        User user4 = new User("Ignat", 16, "School", "Ekb");
        User user5 = new User("Marina", 15, "School", "Spb");

        List<User> users = List.of(user1, user2, user3, user4, user5);
        System.out.println(User.groupUsers(users));
    }
}
