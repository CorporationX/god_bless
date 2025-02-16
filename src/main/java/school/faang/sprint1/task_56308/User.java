package school.faang.sprint1.task_56308;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String adress) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalAccessError("Name cant be Empty");
        } else if (age < 0) {
            throw new IllegalAccessError("Age cannot be negative");
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = adress;
    }


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getAge));
        return map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
