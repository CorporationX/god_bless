package school.faang.bjs2_79134;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String userName;
    @Getter
    private int age;
    private String placeOfWork;
    private String address;

    public User(String userName, int age, String placeOfWork, String address) {
        this.userName = userName;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> grouped = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            if (!grouped.containsKey(age)) {
                grouped.put(age, new ArrayList<>());
            }
            grouped.get(age).add(user);
        }
        return grouped;
    }
}
