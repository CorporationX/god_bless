package faang.school.godbless.groupUsers;

import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    private static Map<Integer, List<User>> groupUsers(List<User> arrayUser) {
        Map<Integer, List<User>> arrayUsers = new HashMap<>();
        for (User elementUser : arrayUser) {
            if (arrayUsers.containsKey(elementUser.getAge())) {
                arrayUsers.get(elementUser.getAge()).add(elementUser);
            } else {
                arrayUsers.put(elementUser.getAge(), new ArrayList<>());
                arrayUsers.get(elementUser.getAge()).add(elementUser);
            }
        }
        return arrayUsers;
    }
}