package school.faang.ageofusers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@lombok.Getter
@lombok.Setter

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


    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> usersMap = new HashMap<>();

        for(User user: users) {
            usersMap.computeIfAbsent(user.getAge(), a -> new ArrayList<>()).add(user);
        }
        return usersMap;
    }
}