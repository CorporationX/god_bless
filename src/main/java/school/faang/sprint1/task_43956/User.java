package school.faang.sprint1.task_43956;

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

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", workplace='" + workplace + '\''
                + ", address='" + address + '\'' + '}' + "\n";
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> groupedUser = new HashMap<>();
        for (User user : users) {
            if (!groupedUser.containsKey(user.getAge())) {
                groupedUser.put(user.getAge(), new ArrayList<>());
            }
            groupedUser.get(user.getAge()).add(user);
        }
        return groupedUser;
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
}
