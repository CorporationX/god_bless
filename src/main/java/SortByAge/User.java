package SortByAge;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
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
        HashMap<Integer, List<User>> mapOfPeers = new HashMap<>();
        for (User user : users) {
            mapOfPeers.putIfAbsent(user.getAge(), new ArrayList<>());
            mapOfPeers.get(user.getAge()).add(user);
        }
        return mapOfPeers;
    }
}
