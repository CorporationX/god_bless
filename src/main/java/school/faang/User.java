package school.faang;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.putIfAbsent(user.age, new ArrayList<>());
            groupedUsers.get(user.age).add(user);
        }
        return groupedUsers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{")
                .append("name='").append(name).append('\'')
                .append(", age=").append(age)
                .append(", workplace='").append(workplace).append('\'')
                .append(", address='").append(address).append('\'')
                .append('}');
        return sb.toString();
    }
}
