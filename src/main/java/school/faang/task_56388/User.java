package school.faang.task_56388;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class User {
    private String name;
    @Setter(AccessLevel.NONE)
    private Integer age;
    private String workplace;
    private String address;

    public User(String name, Integer age, String workplace, String address) {
        this.name = name;
        this.workplace = workplace;
        this.address = address;

        setAge(age);
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersGroupedByAge = new HashMap<>();
        for (User user : users) {
            usersGroupedByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return usersGroupedByAge;
    }

    public void setAge(@NonNull Integer age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "{Name: " + name + ", Age: " + age + "}";
    }
}
