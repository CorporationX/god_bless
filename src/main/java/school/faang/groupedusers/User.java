package school.faang.groupedusers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String name;
    private final int age;
    private final String workplace;
    private final String address;

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

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users){
            List<User> userList = groupedUsers.get(user.getAge());
            if (userList == null){
                userList = new ArrayList<>();
                groupedUsers.put(user.getAge(), userList);
            }
            userList.add(user);
        }
        return groupedUsers;
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
