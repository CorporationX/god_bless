package school.faang;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
