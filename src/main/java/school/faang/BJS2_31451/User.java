package school.faang.BJS2_31451;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    @Override
    public String toString() {
        return "User{name='" +
            name + "', age=" +
            age + ", workplace='" +
            workplace + "', address='" +
            address + "'}";
    }
}
