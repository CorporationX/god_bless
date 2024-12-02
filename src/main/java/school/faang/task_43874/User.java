package school.faang.task_43874;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
    private final String name;
    private final Integer age;
    private final String workplace;
    private final String address;

    public User(String name, Integer age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users
                .stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", workplace='" + workplace + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
