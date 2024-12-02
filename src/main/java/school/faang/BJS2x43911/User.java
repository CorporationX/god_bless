package school.faang.BJS2x43911;

import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@RequiredArgsConstructor
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user : users) {
            mapUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }
        return mapUsers;
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("John", 32, "Google", "New York")
                , new User("Mike", 21, "Uber", "Amsterdam")
                , new User("Lenny", 45, "Google", "London")
                , new User("Jane", 21, "Amazon", "New York")
                , new User("Radjesh", 32, "Amazon", "Amsterdam"));

        Map<Integer, List<User>> ageMap = groupUsers(users);
        System.out.println(ageMap.get(21));

    }
}
