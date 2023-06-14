package faang.school.godbless.GroupUsers;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ToString(includeFieldNames = false)
public class User {
    @Getter
    private String name;
    @Getter
    private int age;
    private String work;
    private String city;

    public User(String name, int age, String work, String city) {
        if (name.isBlank() || age < 0) {
            throw new IllegalArgumentException("Не корректные данные для инициализации.");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.city = city;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
