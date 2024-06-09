package faang.school.godbless.user;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode(of = {"name", "age"})
@NoArgsConstructor
@AllArgsConstructor

public class User {

    private String name;
    private Integer age;
    private String company;
    private String address;


    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> result = new HashMap<>();
        if (users == null) {
            return result;
        }
        for (User user : users) {
            Integer age = user.getAge();
            List<User> listOfUsers = result.getOrDefault(age, new ArrayList<>());
            listOfUsers.add(user);
            result.put(age, listOfUsers);
        }


        return result;
    }

    @Override
    public String toString() {
        return String.format("User: Name - %s, age - %d, company - %s", name, age, company);
    }
}
