package faang.school.godbless._Grouping_users;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> mapUsers = new HashMap<>();
        for (User user : users) {
            if (!mapUsers.containsKey(user.age)) {
                mapUsers.put(user.age, new ArrayList<>());
            }
            mapUsers.get(user.age).add(user);
        }
        return mapUsers;

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", work_place='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
