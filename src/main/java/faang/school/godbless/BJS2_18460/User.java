package faang.school.godbless.BJS2_18460;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String address;
    private String placeOfWork;

    public User(String name, int age, String address, String placeOfWork) {
        this.name = name;
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        }
        this.address = address;
        this.placeOfWork = placeOfWork;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroupsByAge = new HashMap<>();
        for (User user : users) {
            List<User> userListByAge = users.stream()
                    .filter(s -> s.getAge() == user.getAge())
                    .toList();
            userGroupsByAge.put(user.getAge(), userListByAge);
        }
        return userGroupsByAge;
    }
}
