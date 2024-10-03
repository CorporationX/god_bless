package school.faang.groupUsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
    public int getAge() {
        return age;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (!groupedUsers.containsKey(user.age)){
                groupedUsers.put(user.age, new ArrayList<>());
            }
            groupedUsers.get(user.getAge()).add(user);

        }

        return groupedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
