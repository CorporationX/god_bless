package school.faang.sprint_1.task_bjs243909;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), key -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Ivan", 24, "Sber", "Moscow"),
                new User("Petr", 33, "RT", "Kazan"),
                new User("John", 40, "Plunder and Flee Inc.", "New York"),
                new User("Jane", 33, "Google X", "Mountain View"),
                new User("Ashley", 24, "Space X", "Boca Chica")
        );

        Map<Integer, List<User>> groupedUsers = groupUsers(users);
        groupedUsers.forEach((age, usersList) -> {
            System.out.println(age);
            usersList.forEach(System.out::println);
        });
    }
}