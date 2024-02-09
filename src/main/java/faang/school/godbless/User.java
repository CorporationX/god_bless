package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getWork() {

        return work;
    }

    public String getAddress() {
        return getAddress();
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
