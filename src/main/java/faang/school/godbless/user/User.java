package faang.school.godbless.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;

    private Integer age;
    private String workPlace;
    private String address;

    public User(String name, Integer age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        return usersList.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
