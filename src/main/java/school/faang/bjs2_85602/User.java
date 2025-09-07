package school.faang.bjs2_85602;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> resultMap = users.stream()
                .collect(Collectors.groupingBy(User::getAge)); //группировка юзеров по getAge (возрасту)

        return resultMap;
    }

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

    public String toString() {
        return "User{" + name + '}';
    }
}
