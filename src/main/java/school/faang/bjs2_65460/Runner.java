package school.faang.bjs2_65460;

import java.util.List;
import java.util.Map;

import static school.faang.bjs2_65460.User.groupUsers;

public class Runner {

    public static void main(String[] args) {
        List<User> users = List.of(new User("Nikolay", 23, "Steam", "Sidney"),
                new User("Egor", 24, "Netflix", "Hamburg"),
                new User("Sasha", 23, "BMW", "Berlin"),
                new User("Arthur", 25, "Hoyoverse", "Shanghai"));
        Map<Integer, List<User>> groupedUsers = groupUsers(users);
        System.out.println(groupedUsers);
    }
}
