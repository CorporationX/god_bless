package faang.school.godbless.group_by;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private Integer age;
    private String work;
    private String adress;


    public User(String name, Integer age, String work, String adress) {
        this.name = name;
        this.age = age;
        this.work = work;
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {

        Map<Integer, List<User>> usersGroup = new HashMap<>();
        for (User user : listUser) {
            if (!usersGroup.containsKey(user.age)) {
                usersGroup.put(user.age, new ArrayList<>());
            }
            usersGroup.get(user.age).add(user);
        }
        return usersGroup;
    }
}
