package faang.school.godbless.task.ageGroup;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class User {
    @Setter(AccessLevel.NONE)
    private String name;
    @Setter(AccessLevel.NONE)
    private int age;
    private String company;
    private String address;
    public static final int USER_MIN_AGE = 6;

    public User(String name, int age, String company, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Username can't be blank!");
        }
        if (age < USER_MIN_AGE) {
            throw new IllegalArgumentException("User must be over 6 y.o.");
        }

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Username can't be blank!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < USER_MIN_AGE) {
            throw new IllegalArgumentException("User must be over 6 y.o.");
        }
        this.age = age;
    }

}
