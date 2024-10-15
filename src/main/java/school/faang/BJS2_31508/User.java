package school.faang.BJS2_31508;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            List<User> userList = groupedUsers.getOrDefault(age, new ArrayList<>());
            userList.add(user);
            groupedUsers.put(age, userList);
        }

        return groupedUsers;
    }

    public static void main(String[] args) {

        User user1 = new User("Alice", 30, "Google", "London");
        User user2 = new User("Bob", 25, "Uber", "New York");
        User user3 = new User("Charlie", 30, "Amazon", "Amsterdam");
        User user4 = new User("David", 25, "Google", "London");

        List<User> users = Arrays.asList(user1, user2, user3, user4);

        Map<Integer, List<User>> groupedUsers = groupUsers(users);

        groupedUsers.forEach((age, userList) -> {
            System.out.println("Age: " + age);
            userList.forEach(user -> System.out.println("  User: " + user.getName()));
        });
    }

}
