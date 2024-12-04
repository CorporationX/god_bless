package school.faang.sprint_1.task_43895;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int getAge() {
        return age;
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

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedByAge = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            if (!groupedByAge.containsKey(age)) {
                groupedByAge.put(age, new ArrayList<>());
            }
            groupedByAge.get(age).add(user);
        }
        return groupedByAge;
    }
}
