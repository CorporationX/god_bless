package faang.school.godbless.Task18546;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class User {

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        if (users.isEmpty()) {
            throw new IllegalArgumentException("Users list is empty");
        }

        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
