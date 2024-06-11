package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String placeOfWork, address;

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        users.forEach(user -> usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return usersByAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
