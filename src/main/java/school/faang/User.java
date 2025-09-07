package school.faang;

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

    public static Map<Integer, List<User>> groupUsers(List<User> someList) {
        Map<Integer, List<User>> users = new HashMap<>();
        for (User someUser : someList) {
            users.computeIfAbsent(someUser.getAge(), k -> new ArrayList<>()).add(someUser);
        }
        return users;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void print(Map<Integer, List<User>> myMap) {
        for (Map.Entry<Integer, List<User>> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}



