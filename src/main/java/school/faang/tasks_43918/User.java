package school.faang.tasks_43918;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    public static Map<Integer, List<User>> groupByAge(List<User> userList) {
        return userList.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, workplace='%s', address='%s'}",
                name, age, workplace, address);
    }
}
