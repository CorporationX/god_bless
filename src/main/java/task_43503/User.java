package task_43503;

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


        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }


    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Tom", 25, "Corp 1", "Adress A"),
                new User("Sofia", 18, "Corp 2", "Adress B"),
                new User("Bob", 36, "Corp 3", "Adress C"),
                new User("Jerry", 52, "Corp 4", "Adress D")
        );

        for (Map.Entry<Integer,List<User>> usersEntry : User.groupUsers(users).entrySet()){
            System.out.println(usersEntry);
        }

    }



}
