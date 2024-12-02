package school.faang.task_43866;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }


    public static void main(String[] args) {
        List<User> users = List.of(
                new User("user1", 16, "some workplace1", "some address1"),
                new User("user2", 45, "some workplace2", "some address2"),
                new User("user3", 23, "some workplace3", "some address3"),
                new User("user4", 16, "some workplace4", "some address4"),
                new User("user5", 34, "some workplace5", "some address5"),
                new User("user6", 23, "some workplace6", "some address6"),
                new User("user7", 18, "some workplace7", "some address7")
        );

        for (Map.Entry<Integer, List<User>> usersEntry : User.groupUsers(users).entrySet()) {
            System.out.println(usersEntry);
        }

    }
}
