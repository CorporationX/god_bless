package school.faang.bjs243922;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
public class User {

    private String name;
    private Integer age;
    private String workplace;
    private String address;

    public Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> group = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!group.containsKey(age)) {
                group.put(age, new ArrayList<>());
            }
            group.get(age).add(user);
        }

        return group;
    }


    public User(String name, Integer age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

}
