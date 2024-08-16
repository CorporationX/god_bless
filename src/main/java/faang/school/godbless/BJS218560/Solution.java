package faang.school.godbless.BJS218560;

import java.util.List;
import java.util.Set;

import static faang.school.godbless.BJS218560.User.findHobbyLovers;

public class Solution {
    public static void main(String[] args) {
        User user = new User(1, "Lexa", 19, Set.of("basketball", "football", "tennis"));
        User user1 = new User(2, "Andrey", 34, Set.of("football", "tennis"));

        List<User> users = List.of(user, user1);
        Set<String> activity = Set.of("football", "tennis", "test2");
        System.out.println(findHobbyLovers(users, activity));
    }
}
