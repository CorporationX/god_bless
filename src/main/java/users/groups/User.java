package users.groups;


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
       Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            List<User> userList = groupedUsers.get(user.getAge());
            if (userList != null) {
                userList.add(user);
                groupedUsers.put(user.getAge(), userList);
                continue;
            }
            userList = new ArrayList<>();
            userList.add(user);
            groupedUsers.put(user.getAge(), userList);
        }
        return groupedUsers;
    }
}
