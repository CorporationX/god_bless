package faang.school.godbless;

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

    public Integer getUserAge() {
        return this.age;
    }

    public static Map<Integer, List<User>> convertListUserToMap(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getUserAge, Collectors.toList()));
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
