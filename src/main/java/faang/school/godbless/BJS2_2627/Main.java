package faang.school.godbless.BJS2_2627;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var user1 = new User(0, "Bob", 15, new HashSet<>(List.of(new String[]{"1", "2", "3"})));
        var user2 = new User(1, "Sam", 15, new HashSet<>(List.of(new String[]{"2", "5", "4"})));
        System.out.println(User.findHobbyLovers(List.of(user1, user2), new HashSet<>(List.of(new String[]{"4", "6"}))));
    }
}
