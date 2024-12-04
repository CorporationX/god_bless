package school.faang.task43982groupuser;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;
    public static List<User> users = new ArrayList<>();

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupAgeUsers = new HashMap<>();
        for (User user : users) {
            if (groupAgeUsers.containsKey(user.age)) {
                groupAgeUsers.get(user.age).add(user);
            } else {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                groupAgeUsers.put(user.age, userList);
            }
        }
        return groupAgeUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(age, user.age)
                && Objects.equals(name, user.name)
                && Objects.equals(workplace, user.workplace)
                && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }
}
